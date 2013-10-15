package com.huateng.common;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.huateng.exception.ComException;

public class EncryptionTool {
	private static Cipher encrypter = null;
	private static SecretKeySpec key = null;
	private static Cipher db_encrypter = null;
	private static SecretKeySpec db_key = null;
	private static Logger logger = Logger
			.getLogger(com.huateng.common.EncryptionTool.class);
	private final static String CKSuperkey = "*&KKK0*&";
	private final static String PWDKSuperkey = "&ndas9^^";
	private final static String CPWDkey = "665A37CFEBD626CE";

	public final static int PWD_LEN = 8;
	

	/* 加密密码 */
	public static byte[] encrypt_pwd(String pwd) throws ComException {
		try {
			String text = new String(rpad(pwd, PWD_LEN, '\0'));
			byte[] encrypted_text = encrypter.doFinal(text.getBytes());
			debug_buff(encrypted_text);
			/* 转换二进制bcd码至ascii字符 */
			String out = "";
			for (int i = 0; i < PWD_LEN; i++) {
				int k = encrypted_text[i] < 0 ? (((int) encrypted_text[i]) & 0x000000ff)
						: (int) encrypted_text[i];
				out += lpad(Integer.toHexString(k), 2, '0');
			}
			;
			out = out.toUpperCase();
			debug_buff(out.getBytes("ISO-8859-1"));
			return out.getBytes("ISO-8859-1");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ComException(ex.getMessage());
		}
	}

	public static void init(String keyStr) throws ComException {
		try {
			byte[] superKey = getSuperKey();
			logger.debug("enckey is:" + keyStr);
			byte[] desKeyData = decode(keyStr);
			for (int i = 0, k = 0; i < desKeyData.length; i++, k = (k + 1) % 8) {
				desKeyData[i] ^= superKey[k];
			}
			key = new SecretKeySpec(desKeyData, "DES");
			encrypter = Cipher.getInstance("DES");
			encrypter.init(Cipher.ENCRYPT_MODE, key);
		} catch (Exception ex) {
			throw new ComException(ex.getMessage());
		}
	}

	private static byte[] getSuperKey() {
		byte[] VirtualKey = CKSuperkey.getBytes();
		/*
		 * String tempLine=new String(); byte[] lineByte=tempLine.getBytes();
		 * byte tempByte=lineByte[lineByte.length-1];
		 *
		 */

		byte[] buffer = CKSuperkey.getBytes();
		buffer[0] = (byte) (VirtualKey[4] + 1);
		buffer[4] = VirtualKey[0];
		buffer[2] = VirtualKey[3];
		buffer[3] = VirtualKey[2];
		return buffer;
	}

	/* 加密数据库保存密码 */
	public static byte[] encrypt_db_pwd(String pwd) throws ComException {
		try {
			String text = new String(rpad(pwd, PWD_LEN, '\0'));
			if (db_key == null || db_encrypter == null) {
				/* init the key */
				db_encrypter = Cipher.getInstance("DES");
				init_db_key();
				db_encrypter.init(Cipher.ENCRYPT_MODE, db_key);
			}
			byte[] encrypted_text = db_encrypter.doFinal(text.getBytes());
			debug_buff(encrypted_text);
			/* 转换二进制bcd码至ascii字符 */
			String out = "";
			for (int i = 0; i < PWD_LEN; i++) {
				int k = encrypted_text[i] < 0 ? (((int) encrypted_text[i]) & 0x000000ff)
						: (int) encrypted_text[i];
				out += lpad(Integer.toHexString(k), 2, '0');
			}
			;
			out = out.toUpperCase();
			debug_buff(out.getBytes("ISO-8859-1"));
			/*
			 * String encrypted_text = new String(ret,0,PWD_LEN,"ISO-8859-1");
			 * debug_buff( encrypted_text.getBytes("ISO-8859-1"));
			 */
			return out.getBytes("ISO-8859-1");
		} catch (Exception ex) {
			throw new ComException(ex.getMessage());
		}
	}

	private static void init_db_key() throws ComException {
		String key_str = CPWDkey;
		byte[] superKey = getDbSuperKey();
		logger.debug("enckey is:" + key_str);
		byte[] desKeyData = decode(key_str);
		for (int i = 0, k = 0; i < desKeyData.length; i++, k = (k + 1) % 8) {
			desKeyData[i] ^= superKey[k];
		}
		db_key = new SecretKeySpec(desKeyData, "DES");
	}

	private static byte[] getDbSuperKey() {
		byte[] VirtualKey = PWDKSuperkey.getBytes();
		byte[] buffer = PWDKSuperkey.getBytes();
		buffer[0] = (byte) (VirtualKey[4] + 1);
		buffer[4] = VirtualKey[0];
		buffer[2] = VirtualKey[3];
		buffer[3] = VirtualKey[2];
		return buffer;
	}

	private static void debug_buff(byte[] message) {
		int i = 0;
		StringBuffer buff = new StringBuffer();
		StringBuffer buff2 = new StringBuffer();
		StringBuffer outbuf = new StringBuffer();
		outbuf.append("\n======================" + message.length + " bytes:");
		while (i < message.length) {
			if ((i % 16) == 0) {
				buff.append(lpad(Integer.toHexString(i / 16), 4, '0'));
				buff.append(" : ");
			}
			int k = message[i] < 0 ? (((int) message[i]) & 0x000000ff)
					: (int) message[i];
			buff.append(lpad(Integer.toHexString(k), 2, '0')).append(" ");
			if (Character.isLetterOrDigit((char) message[i])
					|| Character.isSpaceChar((char) message[i]))
				buff2.append((char) message[i]);
			else
				buff2.append('.');
			if ((i % 16) == 7)
				buff.append("- ");
			if ((i % 16) == 15) {
				buff.append(buff2);
				outbuf.append("\n" + buff);
				buff.delete(0, buff.length());
				buff2.delete(0, buff2.length());
			}
			i++;
		}
		outbuf.append(buff.append(buff2));
		logger.debug("encrypted text:" + outbuf);
	}

	private static StringBuffer lpad(String s, int len, char c) {
		int i = len - s.length();
		StringBuffer ret = new StringBuffer(len);
		if (i <= 0)
			return new StringBuffer(s);
		while (i > 0) {
			ret.append(c);
			i--;
		}
		ret.append(s);
		return ret;
	}

	private static StringBuffer rpad(String s, int len, char c) {
		int i = len - s.length();
		StringBuffer ret = new StringBuffer(len);
		if (i <= 0)
			return new StringBuffer(s);
		ret.append(s);
		while (i > 0) {
			ret.append(c);
			i--;
		}
		return ret;
	}

	/* 16进制表示的字符串转换成字节数组 */
	private static byte[] decode(String s) throws ComException {
		byte[] ret = new byte[8];
		char c, c1;
		int x;
		if (s.length() != 16)
			throw new ComException("密钥格式不正确");
		for (int i = 0; i < 16; i++) {
			c = s.charAt(i);
			c1 = s.charAt(++i);
			if (!(c >= '0' && c <= '9' || c >= 'A' && c <= 'F' || c >= 'a'
					&& c <= 'f'))
				throw new ComException("密钥格式不正确");
			if (!(c1 >= '0' && c1 <= '9' || c1 >= 'A' && c1 <= 'F' || c1 >= 'a'
					&& c1 <= 'f'))
				throw new ComException("密钥格式不正确");
			x = Integer.decode("0x" + c + c1).intValue();
			if (x > 127) {
				ret[i / 2] = (byte) (x | 0xffffff00);
			} else {
				ret[i / 2] = (byte) (x);
			}
		}
		return ret;
	}
}
