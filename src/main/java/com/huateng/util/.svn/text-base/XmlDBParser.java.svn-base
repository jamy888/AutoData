package com.huateng.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.DefaultCDATA;

import com.huateng.common.ComCons;
import com.huateng.common.Module;
import com.huateng.common.Rescode;
import com.huateng.common.XmlDBConstants;
import com.huateng.exception.ComException;

/**
 * Title: XmlDB解析器
 *
 * Description:
 *
 * Copyright: Copyright (c) 2006
 *
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author robertbao
 *
 * @version 1.0, 2007-1-10
 */
public class XmlDBParser {

	protected static Logger logger = Logger.getLogger(ComCons.XML_DB);

	/** memeber variable: dom4j SAXReader. */
	private SAXReader saxReader;

	public XmlDBParser() {
		saxReader = new SAXReader();
	}

	/**
	 * 解析sysDic,为移动一期修改
	 *
	 * @param configFile
	 * @throws ComException
	 */
	public void parseSysDic(Document document) throws ComException {
		try {

			//Document document = saxReader.read(configFile);
			List fieldList = document.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);
			Element field;

			for (int i = 0; i < fieldList.size(); i++) {
				field = (Element) fieldList.get(i);

				// List
				// aList=field.selectNodes("/"+XmlDBConstants.SYS_DIC_TBL_NM);

				Node tblNmNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_TBL_NM);
				Node fldNmNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_NM);
				Node fldValNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_VAL);
				Node fldDescNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_DESC);
				Node lastUpdOprIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_OPR_ID);
				Node lastUpdTxnIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TXN_ID);
				Node lastUpdTsNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TS);

				if (logger.isDebugEnabled()) {
					logger.debug(ComCons.traceInfo("-----SysDic-----"));
					logger
							.debug(ComCons.traceInfo(tblNmNode
									.getText()));
					logger
							.debug(ComCons.traceInfo(fldNmNode
									.getText()));
					logger
							.debug(ComCons.traceInfo(fldNmNode
									.getText()));
					logger.debug(ComCons.traceInfo(fldDescNode
							.getText()));
				}

				SystemDictionaryUnit
						.addRecord(tblNmNode.getText(), fldNmNode.getText(),
								fldValNode.getText(), fldDescNode.getText());

			}
		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_INIT_CONFIG_FILE_FIELD_NOEXISTS,
					"parse config file:Fields Parameter error", ex);
		}
	}

	/**
	 * 解析SysDic
	 *
	 * @param configFile
	 * @throws ComException
	 */
	public void parseSysDic(File configFile) throws ComException {
		try {

			Document document = saxReader.read(configFile);
			List fieldList = document.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);
			Element field;

			for (int i = 0; i < fieldList.size(); i++) {
				field = (Element) fieldList.get(i);

				// List
				// aList=field.selectNodes("/"+XmlDBConstants.SYS_DIC_TBL_NM);

				Node tblNmNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_TBL_NM);
				Node fldNmNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_NM);
				Node fldValNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_VAL);
				Node fldDescNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_DESC);
				Node lastUpdOprIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_OPR_ID);
				Node lastUpdTxnIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TXN_ID);
				Node lastUpdTsNode = field
						.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TS);

				if (logger.isDebugEnabled()) {
					logger.debug(ComCons.traceInfo("-----SysDic-----"));
					logger
							.debug(ComCons.traceInfo(tblNmNode
									.getText()));
					logger
							.debug(ComCons.traceInfo(fldNmNode
									.getText()));
					logger
							.debug(ComCons.traceInfo(fldNmNode
									.getText()));
					logger.debug(ComCons.traceInfo(fldDescNode
							.getText()));
				}

				SystemDictionaryUnit
						.addRecord(tblNmNode.getText(), fldNmNode.getText(),
								fldValNode.getText(), fldDescNode.getText());

			}
		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_INIT_CONFIG_FILE_FIELD_NOEXISTS,
					"parse config file:Fields Parameter error", ex);
		}
	}

	/**
	 * 解析SysPrm和PrmDef
	 *
	 * @param sysPrmFile
	 * @param prmDefFile
	 * @throws ComException
	 */
	public void parseSysPrm(File sysPrmFile, File prmDefFile)
			throws ComException {
		try {
			Document sysPrmDocument = saxReader.read(sysPrmFile);
			Document prmDefDocument = saxReader.read(prmDefFile);

			List sysPrmList = sysPrmDocument.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);

			List prmDefList = prmDefDocument.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);

			Element field;

			// sysPrm��ȡ
			for (int i = 0; i < sysPrmList.size(); i++) {
				field = (Element) sysPrmList.get(i);
				Node paramIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_PRM_PARAM_ID);
				Node magicIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_PRM_MAGIC_ID);
				Node paramValueTxNode = field
						.selectSingleNode(XmlDBConstants.SYS_PRM_PARAM_VALUE_TX);

				if (logger.isDebugEnabled()) {
					logger.debug(ComCons.traceInfo("-----SysPrm-----"));
					logger.debug(ComCons.traceInfo(paramIdNode
							.getText()));
					logger.debug(ComCons.traceInfo(magicIdNode
							.getText()));
					logger.debug(ComCons.traceInfo(paramValueTxNode
							.getText()));
				}

				SysPrmUnit.addRecord(paramIdNode.getText(), magicIdNode
						.getText(), paramValueTxNode.getText());

			}

			// prmDef��ȡ
			for (int i = 0; i < prmDefList.size(); i++) {
				field = (Element) prmDefList.get(i);

				Node paramIdNode = field
						.selectSingleNode(XmlDBConstants.SYS_PRM_PARAM_ID);
				Node defaultValTxNode = field
						.selectSingleNode(XmlDBConstants.PRM_DEF_DEFAULT_VAL_TX);

				if (logger.isDebugEnabled()) {
					logger.debug(ComCons.traceInfo("-----PrmDef-----"));
					logger.debug(ComCons.traceInfo(paramIdNode
							.getText()));
					logger.debug(ComCons.traceInfo(defaultValTxNode
							.getText()));
				}

				SysPrmUnit.addDefRecord(paramIdNode.getText(), defaultValTxNode
						.getText());
			}

		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_INIT_CONFIG_FILE_FIELD_NOEXISTS,
					"parse config file: Fields Parameter error", ex);
		}
	}

	/**
	 * 数据写入SysDic
	 *
	 * @param configFile
	 * @param fields
	 * @throws ComException
	 */
	public void writeSysDic(File configFile, String[] fields)
			throws ComException {

		try {

			Document document = saxReader.read(configFile);
			List fieldList = document.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT);
			Element field = null;

			if (configFile.getName().equals("SysDic.xml")) {
				for (int i = 0; i < fieldList.size(); i++) {
					field = (Element) fieldList.get(i);
					Element rowElement = field.addElement("row");

					// ����ڵ�
					Element sysDicTblNm = rowElement
							.addElement(XmlDBConstants.SYS_DIC_TBL_NM);
					Element sysDicFldNm = rowElement
							.addElement(XmlDBConstants.SYS_DIC_FLD_NM);
					Element sysDicFldVal = rowElement
							.addElement(XmlDBConstants.SYS_DIC_FLD_VAL);
					Element sysDicFldDesc = rowElement
							.addElement(XmlDBConstants.SYS_DIC_FLD_DESC);
					Element sysDicLastUpdOprId = rowElement
							.addElement(XmlDBConstants.SYS_DIC_LAST_UPD_OPR_ID);
					Element sysDicLastUpdTxnId = rowElement
							.addElement(XmlDBConstants.SYS_DIC_LAST_UPD_TXN_ID);
					Element sysDicLastUpdTs = rowElement
							.addElement(XmlDBConstants.SYS_DIC_LAST_UPD_TS);

					// CDATA��ʽ��
					DefaultCDATA sysDicTblNmCdata = new DefaultCDATA(fields[0]);
					DefaultCDATA sysDicFldNmCdata = new DefaultCDATA(fields[1]);
					DefaultCDATA sysDicFldValCdata = new DefaultCDATA(fields[2]);
					DefaultCDATA sysDicFldDescCdata = new DefaultCDATA(
							fields[3]);
					DefaultCDATA sysDicLastUpdOprIdCdata = new DefaultCDATA(
							fields[4]);
					DefaultCDATA sysDicLastUpdTxnIdCdata = new DefaultCDATA(
							fields[5]);
					DefaultCDATA sysDicLastUpdTsCdata = new DefaultCDATA(
							fields[6]);

					// ����CDATA�ı�
					sysDicTblNm.add(sysDicTblNmCdata);
					sysDicFldNm.add(sysDicFldNmCdata);
					sysDicFldVal.add(sysDicFldValCdata);
					sysDicFldDesc.add(sysDicFldDescCdata);
					sysDicLastUpdOprId.add(sysDicLastUpdOprIdCdata);
					sysDicLastUpdTxnId.add(sysDicLastUpdTxnIdCdata);
					sysDicLastUpdTs.add(sysDicLastUpdTsCdata);

					OutputFormat format = OutputFormat.createPrettyPrint();
					format.setEncoding("utf-8");
					XMLWriter output = new XMLWriter(new FileOutputStream(
							configFile), format);
					output.write(document);
					output.close();
				}

			}

		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_WRITE_XMLDB_ERROR, "write error", ex);
		}
	}

	/**
	 * 数据修改XmlDB
	 *
	 * @param configFile
	 * @param fields
	 * @throws ComException
	 */
	public boolean modifySysPrm(File configFile, int i,
			ArrayList newList) throws ComException {

		try {
			int arrayNum = 0;
			Document document = saxReader.read(configFile);
			List fieldList = document.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);
			Element field = null;

			field = (Element) fieldList.get(i);

			Iterator iterator = field.elementIterator();
			while (iterator.hasNext()) {

				Element element = (Element) iterator.next();

				DefaultCDATA newCdata = new DefaultCDATA((String) newList
						.get(arrayNum));

				element.setText("\n");
				//element.remove(oldCdata);
				element.add(newCdata);
				arrayNum++;

			}

			if (logger.isDebugEnabled()) {

				logger.debug(ComCons.traceInfo("-----modifySysPrm-----"));

			}

			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter output = new XMLWriter(new FileOutputStream(configFile),
					format);
			output.write(document);
			output.close();
			return true;

		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_WRITE_XMLDB_ERROR, "write error", ex);
		}
	}

	/**
	 * 读取XmlDB List
	 *
	 * @param configFile
	 * @param fields
	 * @throws ComException
	 */
	public List readXmlDBList(File configFile) throws ComException {

		try {
//			configFile = new File(BaseConstants.rootPath + File.separator
//					+ "WEB-INF"+File.separator+"xmlDB"+File.separator+"SysPrm.xml");
			Document document = saxReader.read(configFile);
			List fieldList = document.selectNodes("//"
					+ XmlDBConstants.TABLE_ROOT + "/"
					+ XmlDBConstants.TABLE_ROW);
			return fieldList;

		} catch (Exception ex) {
			throw new ComException(Module.SYSTEM_MODULE,
					Rescode.XMLDBUTIL_READ_XMLDB_ERROR, "read error", ex);
		}
	}

	/**
	 * 读取SysPrm
	 *
	 * @param configFile
	 * @param fields
	 * @throws ComException
	 */
	public ArrayList readSysDic(List list, int i) throws ComException {

		Element field = null;

		field = (Element) list.get(i);

		Node tblNmNode = field
			 	.selectSingleNode(XmlDBConstants.SYS_DIC_TBL_NM);
		Node fldNmNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_NM);
		Node fldValNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_VAL);
		Node fldDescNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_FLD_DESC);
		Node lastUpdOprIdNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_OPR_ID);
		Node lastUpdTxnIdNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TXN_ID);
		Node lastUpdTsNode = field
				.selectSingleNode(XmlDBConstants.SYS_DIC_LAST_UPD_TS);

		if (logger.isDebugEnabled()) {

			logger.debug(ComCons.traceInfo("-----readSysDic-----"));

		}

		ArrayList arrayList = new ArrayList();

		arrayList.add(tblNmNode.getText());
		arrayList.add(fldNmNode.getText());
		arrayList.add(fldValNode.getText());
		arrayList.add(fldDescNode.getText());
		arrayList.add(lastUpdOprIdNode.getText());
		arrayList.add(lastUpdTxnIdNode.getText());
		arrayList.add(lastUpdTsNode.getText());


		return arrayList;

	}

	/**
	 * 读取SysPrm
	 *
	 * @param configFile
	 * @param fields
	 * @throws ComException
	 */
	public ArrayList readSysPrm(List list, int i) throws ComException {

		Element field = null;

		field = (Element) list.get(i);

		Node paramIdNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_PARAM_ID);
		Node magicIDNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_MAGIC_ID);
		Node paramValueTxNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_PARAM_VALUE_TX);
		Node lastUpdOprIdNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_LAST_UPD_OPR_ID);
		Node lastUpdTxnIdNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_LAST_UPD_TXN_ID);
		Node lastUpdTsNode = field
				.selectSingleNode(XmlDBConstants.SYS_PRM_LAST_UPD_TS);

		if (logger.isDebugEnabled()) {

			logger.debug(ComCons.traceInfo("-----readSysPrm-----"));

		}

		// HashMap hashMap = new HashMap();
		//
		// hashMap.put(XmlDBConstants.SYS_PRM_PARAM_ID, paramIdNode.getText());
		// hashMap.put(XmlDBConstants.SYS_PRM_MAGIC_ID, magicIDNode.getText());
		// hashMap.put(XmlDBConstants.SYS_PRM_PARAM_VALUE_TX, paramValueTxNode
		// .getText());
		// hashMap.put(XmlDBConstants.SYS_PRM_LAST_UPD_OPR_ID, lastUpdOprIdNode
		// .getText());
		// hashMap.put(XmlDBConstants.SYS_PRM_LAST_UPD_TXN_ID, lastUpdTxnIdNode
		// .getText());
		// hashMap
		// .put(XmlDBConstants.SYS_PRM_LAST_UPD_TS, lastUpdTsNode
		// .getText());

		ArrayList arrayList = new ArrayList();

		arrayList.add(paramIdNode.getText());
		arrayList.add(magicIDNode.getText());
		arrayList.add(paramValueTxNode.getText());
		arrayList.add(lastUpdOprIdNode.getText());
		arrayList.add(lastUpdTxnIdNode.getText());
		arrayList.add(lastUpdTsNode.getText());

		return arrayList;

	}

}