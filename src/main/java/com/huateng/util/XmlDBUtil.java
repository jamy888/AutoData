package com.huateng.util;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huateng.common.ComCons;
import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.common.SystemDProperty;
import com.huateng.common.XmlDBConstants;
import com.huateng.exception.ComException;

/**
 * Title: ����XmlDB
 *
 * Description:
 *
 * Copyright: Copyright (c) 2006
 *
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author robertbao
 *
 * @version 1.0, 2007-1-9
 */
public class XmlDBUtil {

	/**
	 * 初始化xmlDB配置
	 *
	 * @param confFiles
	 * @throws ComException
	 */
	public static void init(String[] confFiles,ServletContext context) throws ComException {
		servletContext = context;
		initMeta(confFiles);
		initXmlDBFile();
	}

	/**
	 * 初始化xmlDB2配置
	 *
	 * @param confFiles
	 * @throws ComException
	 * add by chenchong
	 */
	public static void init2(String[] confFiles,ServletContext context) throws ComException {
		servletContext = context;
		initMeta(confFiles);
		initXmlDBFileMECPManagement();
	}


	private static HashMap configMap = new HashMap(2);

	private static HashMap metaMap = new HashMap(2);

	private static ServletContext servletContext = null;

	/**
	 * 初始化Meta文件
	 *
	 * @param confFiles
	 * @throws ComException
	 */
	public static void initMeta(String[] confFiles) throws ComException {
		int num = confFiles.length;
		File metaFile = null;
		Document document;
		Element element;
		List list, l;
		Attribute id, path;
		try {
			SAXReader saxReader = new SAXReader();
			for (int i = 0; i < num; i++) {
				if (SystemDProperty.isProductionMode()) {
					document = saxReader.read(servletContext.getResourceAsStream(confFiles[i]));
				} else{
					metaFile = new File(ComCons.rootPath + File.separator + confFiles[i]);
					document = saxReader.read(metaFile);
					if (!metaFile.exists()) {
						throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_FILE_NOEXISTS, "Meta File :" + confFiles[i] + " no exists");
					}
				}

				list = document.selectNodes("//" + XmlDBConstants.META_ROOT + "/" + XmlDBConstants.META_TABLE);
				for (int j = 0; j < list.size(); j++) {
					element = (Element) list.get(j);
					l = element.selectNodes("@" + XmlDBConstants.META_TABLE_ID);
					if (l.size() != 1) {
						throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_PARSE_TABLE_ID_ERROR, "Table.id error");
					}
					id = (Attribute) l.get(0);
					l = element.selectNodes("@" + XmlDBConstants.META_TABLE_PATH);
					if (l.size() != 1) {
						throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_PARSE_TABLE_PATH_ERROR, "Table.path error");
					}
					path = (Attribute) l.get(0);
					// key=Table Id, value=Table Path
					metaMap.put(id.getValue(), path.getValue());
				}

			}
		}catch (ComException appEx) {
			throw appEx;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_PARSE_FILE_ERROR, ex);
		}

	}

	/**
	 * 初始化xmlDB, 包括数据字典表,参数定义表和参数表
	 *
	 * @throws ComException
	 */
	public static void initXmlDBFileMECPManagement() throws ComException {
		try {
			XmlDBParser parser = new XmlDBParser();
			Iterator it = metaMap.keySet().iterator();
			String id, path;
			File xmlDBFile;
			File sysPrmFile = null;
			Document document;

			while (it.hasNext()) {
				id = (String) it.next();
				path = (String) metaMap.get(id);
				SAXReader saxReader = new SAXReader();
				System.out.println("path==========================="+path);
				document = saxReader.read(servletContext.getResourceAsStream(path));
				parser.parseSysDic(document);
				/*xmlDBFile = new File(BufferConstants.rootPath + File.separator + path);
				if (!xmlDBFile.exists()) {
					throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_CONFIG_FILE_NOEXISTS, "xmlDB Config File :" + path + " no exists");
				}
				if (xmlDBFile.getName().equals(XmlDBConstants.SYS_DIC_FILE)) {

					parser.parseSysDic(xmlDBFile);

				} else if (xmlDBFile.getName().equals(XmlDBConstants.SYS_PRM_FILE)) {

					sysPrmFile = new File(BufferConstants.rootPath + File.separator + path);

				} else if (xmlDBFile.getName().equals(XmlDBConstants.PRM_DEF_FILE)) {

					parser.parseSysPrm(sysPrmFile, xmlDBFile);

				}*/
			}
		} catch (ComException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_PARSE_FILE_ERROR, ex);
		}
	}

	/**
	 * 初始化xmlDB, 包括数据字典表,参数定义表和参数表
	 *
	 * @throws ComException
	 */
	public static void initXmlDBFile() throws ComException {
		try {
			XmlDBParser parser = new XmlDBParser();
			Iterator it = metaMap.keySet().iterator();
			String id, path;
//			File xmlDBFile;
//			File sysPrmFile = null;
			Document sysPrmFile;
			Document xmlDBFile;
			while (it.hasNext()) {
				id = (String) it.next();
				path = (String) metaMap.get(id);

				SAXReader saxReader = new SAXReader();
				xmlDBFile = saxReader.read(servletContext.getResourceAsStream(path));

				if (path.equals(XmlDBConstants.SYS_DIC_FILE)) {
					parser.parseSysDic(xmlDBFile);
				}
			}
		} catch (ComException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE, Rescode.XMLDBUTIL_INIT_META_PARSE_FILE_ERROR, ex);
		}
	}

}
