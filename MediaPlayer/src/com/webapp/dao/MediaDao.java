package com.webapp.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.webapp.entity.Media;
import com.webapp.util.DBConn;

public abstract class MediaDao {
	
	public static Connection conn = null;
	public static QueryRunner qRunner = null;

	/**
	 * ��Ƶת��
	 * 
	 * @param ffmpegPath
	 *            ת�빤�ߵĴ��·��
	 * @param upFilePath
	 *            ����ָ��Ҫת����ʽ���ļ�,Ҫ��ͼ����ƵԴ�ļ�
	 * @param codcFilePath
	 *            ��ʽת����ĵ��ļ�����·��
	 * @param mediaPicPath
	 *            ��ͼ����·��
	 * @return
	 * @throws Exception
	 */
	public boolean executeCodecs(String ffmpegPath, String upFilePath,
			String codcFilePath, String mediaPicPath) throws Exception {
		return false;
	}

	/**
	 * �����ļ�
	 * 
	 * @param media
	 * @return
	 * @throws Exception
	 */
	public boolean saveMedia(Media media) throws Exception {
		return false;
	}

	/**
	 * ��ѯ���ؿ������м�¼����Ŀ
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getAllMediaCount() throws Exception {
		return 0;
	}

	/**
	 * ����ҳ�Ĳ�ѯ
	 * 
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<Media> queryALlMedia(int firstResult, int maxResult)
			throws Exception {
		return null;
	}

	/**
	 * ����Id��ѯ��Ƶ
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Media queryMediaById(int id) throws Exception {
		return null;
	}
	
	/**
	 * ��ȡ���ݿ�����
	 */
	public static void init(){
    	DBConn dbConn  = new DBConn();
        conn = dbConn.getConntion(); 
        //����SQLִ�й���   
       qRunner = new QueryRunner();   
    }
}
