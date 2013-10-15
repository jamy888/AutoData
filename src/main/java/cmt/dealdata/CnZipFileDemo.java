package cmt.dealdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import com.agile.zip.CnZipInputStream;
import com.agile.zip.CnZipOutputStream;
import com.agile.zip.ZipEntry;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 *文件名：CnZipFileDemo.java<br>
 *@author liuzx<br>
 *版本:<br>
 *描述：对JDK的java.util.zip下的ZipInputStream和ZipOutputStream类进行改造，
 * 重新生成CnZipInputStream和CnZipOutputStream类，增加了指定字符集编码功能，
 * 以解决压缩和解压缩文件时的中文文件名问题<br>
 * 所有改造的类文件都在com.agile.zip目录下。也可以将该目录下的类文件打成jar包使用。
 *创建时间:2008-4-15 下午02:21:02<br>
 *文件描述：<br>
 *修改者：<br>
 *修改日期：<br>
 *修改描述：<br>
 */
public class CnZipFileDemo {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 显示zip压缩文件中的文件列表
	 * @param zipfilename 压缩文件的路径及名称
	 * @throws Exception
	 */
	public void getZipFilesList(String zipfilename) {		
		try {
			FileInputStream in = new FileInputStream(zipfilename);
			CnZipInputStream jins = null;
			jins = new CnZipInputStream(in);
			//System.out.println(jins.encoding);
			long dataSize = 0;
			
			String fileName = null;
			String destFileName = null;

			ZipEntry jarentry = null;		
			while (jins.available() > 0) {
				jarentry = jins.getNextEntry();
				if (jarentry == null) {
					break;
				}
				if (jarentry.isDirectory()){
					continue;		
				}
				fileName = jarentry.getName();
				dataSize = jarentry.getSize();
				System.out.println(fileName + ":" + dataSize);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("文件不存在！");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("文件读取失败！");
		}
		
	}

	/**
	 * 将文件（或文件夹）进行压缩为指定的zip文件
	 * @param inputFileName 要压缩的文件或文件夹 
	 * @param outputFileName 压缩后的zip文件
	 * @param encoding 指定字符集编码，默认为UTF-8
	 * @throws Exception
	 */
	public void zip(String inputFileName, String outputFileName) throws Exception {
		zip(inputFileName,outputFileName,"UTF-8");
	}
	
	public void zip(String inputFileName, String outputFileName,String encoding) throws Exception {
		if(encoding==null || encoding.equals("")) encoding = "UTF-8";
		
		File file = new File(outputFileName);
		if(file.exists()){//如果要压缩后的zip文件已经存在，则先将该文件删除
			file.delete();
		}
		CnZipOutputStream out = new CnZipOutputStream(new FileOutputStream(outputFileName),encoding);
		zip(out, new File(inputFileName), "");
		logger.info("压缩完成！");
		out.close();
	}

	private void zip(CnZipOutputStream out, File f, String base)
			throws Exception {
		if (f.isDirectory()) {// 文件夹
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				//System.out.println("i=" + i + "," + fl[i].getName());
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {// 文件
			if (base.length() == 0) {// 当base为空时，表示是压缩指定的一个文件，否则就是压缩文件夹下的所有文件
				base = f.getName();
			}
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			logger.info(base);
			byte[] buffer = new byte[1024];// 提高文件压缩的速度
			while ((b = in.read(buffer)) != -1) {
				out.write(buffer, 0, b);
			}
			in.close();
		}
	}

	/**
	 * 将指定的zip文件解压到指定的目录下,如果文件已存在则覆盖。
	 * @param compress zip压缩文件,如 D:/doc_c06_net.zip
	 * @param decompression 解压路径,如 D:/doc_redcome_com/
	 * @param encoding 解压字符集编码,默认为UTF-8
	 * @throws Exception
	 */
	public void dezip(String compress,String decompression){
		dezip(compress,decompression,null);
	}
	public void dezip(String compress,String decompression,String encoding){
		if(encoding==null || encoding.equals("")) encoding = "UTF-8";
		File infile = new File(compress);
		File dir = new File(decompression);

		try {
			// 检查是否是ZIP文件
			ZipFile zip = new ZipFile(infile);
			zip.close();
			// 建立与目标文件的输入连接
			CnZipInputStream in = new CnZipInputStream(new FileInputStream(infile), encoding);
			ZipEntry file = in.getNextEntry();
			System.out.println(in.encoding);
			byte[] c = new byte[1024];
			int len;
			int slen;
			while (file != null) {
				String zename = file.getName();
				if (file.isDirectory()) {
					File files = new File(dir.getAbsolutePath() + "/" + zename); //在指定解压路径下建子文件夹
					//System.out.println(files.getAbsolutePath());
					files.mkdirs();//新建文件夹
				} else {
					File files = new File(dir.getAbsolutePath() + "/" + zename).getParentFile();//当前文件所在目录
					//System.out.println(files.getAbsolutePath());
					if (!files.exists())  {//如果目录文件夹不存在，则创建
						files.mkdirs();
					}
					FileOutputStream out = new FileOutputStream(dir.getAbsolutePath() + "/" + zename);
					while ((slen = in.read(c, 0, c.length)) != -1)
						out.write(c, 0, slen);
					out.close();
				}
				//System.out.print(zename+" O.K.\n");
				file = in.getNextEntry();
			}
			in.close();
		} catch (ZipException zipe) {
			logger.error(infile.getName() + "不是一个ZIP文件！文件格式错误");
		} catch (IOException ioe) {
			logger.error("读取" + compress + "时错误！文件读取错误");
		} catch (Exception i) {
			logger.error(i.getMessage()+"   over");
		}

		
	}
	

	public static void main(String[] args)  {
		CnZipFileDemo zt = new CnZipFileDemo();
		//zt.getZipFilesList("D:\\temp\\AutoData\\aaa.zip");//显示zip文件内容
		
		try {
			zt.zip("D:\\temp\\AutoData\\temp", "D:\\temp\\AutoData\\temp.zip","GBK");//压缩文件
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			zt.dezip("c:/kvm日志.zip", "c:/kvmlog");//解压缩文件
			zt.dezip("c:/联系.zip", "c:/liuzx");//解压缩文件
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
