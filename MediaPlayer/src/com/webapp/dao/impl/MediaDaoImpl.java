package com.webapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.webapp.dao.MediaDao;
import com.webapp.entity.Media;

public class MediaDaoImpl extends MediaDao{
	

	/**
     * ��Ƶת��
     * @param ffmpegPath    ת�빤�ߵĴ��·��
     * @param upFilePath    ����ָ��Ҫת����ʽ���ļ�,Ҫ��ͼ����ƵԴ�ļ�
     * @param codcFilePath    ��ʽת����ĵ��ļ�����·��
     * @param mediaPicPath    ��ͼ����·��
     * @return
     * @throws Exception
     */
	public boolean executeCodecs(String ffmpegPath, String upFilePath, String codcFilePath,
            String mediaPicPath) throws Exception {
        // ����һ��List����������ת����Ƶ�ļ�Ϊflv��ʽ������
        List<String> convert = new ArrayList<String>();
        convert.add(ffmpegPath); // ���ת������·��
        convert.add("-i"); // ��Ӳ�����-i�����ò���ָ��Ҫת�����ļ�
        convert.add(upFilePath); // ���Ҫת����ʽ����Ƶ�ļ���·��
        convert.add("-qscale");     //ָ��ת��������
        convert.add("6");
        convert.add("-ab");        //������Ƶ����
        convert.add("64");
        convert.add("-ac");        //����������
        convert.add("2");
        convert.add("-ar");        //���������Ĳ���Ƶ��
        convert.add("22050");
        convert.add("-r");        //����֡Ƶ
        convert.add("24");
        convert.add("-y"); // ��Ӳ�����-y�����ò���ָ���������Ѵ��ڵ��ļ�
        convert.add(codcFilePath);

        // ����һ��List�������������Ƶ�н�ȡͼƬ������
        List<String> cutpic = new ArrayList<String>();
        cutpic.add(ffmpegPath);
        cutpic.add("-i");
        cutpic.add(upFilePath); // ͬ�ϣ�ָ�����ļ���������ת��Ϊflv��ʽ֮ǰ���ļ���Ҳ������ת����flv�ļ���
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); // ��Ӳ�����-ss�����ò���ָ����ȡ����ʼʱ��
        cutpic.add("17"); // �����ʼʱ��Ϊ��17��
        cutpic.add("-t"); // ��Ӳ�����-t�����ò���ָ������ʱ��
        cutpic.add("0.001"); // ��ӳ���ʱ��Ϊ1����
        cutpic.add("-s"); // ��Ӳ�����-s�����ò���ָ����ȡ��ͼƬ��С
        cutpic.add("800*280"); // ��ӽ�ȡ��ͼƬ��СΪ350*240
        cutpic.add(mediaPicPath); // ��ӽ�ȡ��ͼƬ�ı���·��

        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(convert);
            builder.redirectErrorStream(true);
            builder.start();
            
            builder.command(cutpic);
            builder.redirectErrorStream(true);
            // ���������Ϊ true�����κ���ͨ���˶���� start() ���������ĺ����ӽ������ɵĴ�������������׼����ϲ���
            //������߾���ʹ�� Process.getInputStream() ������ȡ����ʹ�ù���������Ϣ����Ӧ�������ø�����
            builder.start();
        } catch (Exception e) {
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
        return mark;
    }

	

	public int getAllMediaCount() throws Exception {
		super.init();
		//��̬����SQL���
		String strSQL = "select COUNT(*) from tb_media";
		int counter = qRunner.query(conn, strSQL,null);
		DbUtils.closeQuietly(conn); 
		return counter;
	}

	@SuppressWarnings("deprecation")
	public List<Media> queryALlMedia(int firstResult,
			int maxResult) throws Exception {
		super.init();
		//��̬����SQL���
		String strSQL = "select * from tb_media limit ?,?";
		List<Media> lstMedia = (List<Media>)qRunner.query(conn, strSQL,new Object[]{firstResult,maxResult},new BeanListHandler<Media>(Media.class));
		DbUtils.closeQuietly(conn); 
		return lstMedia;
	}

	@SuppressWarnings("deprecation")
	public Media queryMediaById(int id) throws Exception {
		super.init();
		//��̬����SQL���
		String strSQL = "select * from tb_media where id = ?";
		Media media = qRunner.query(conn, strSQL,new Object[]{id},new BeanListHandler<Media>(Media.class)).get(0);
		DbUtils.closeQuietly(conn); 
		return media;
	}

	public boolean saveMedia(Media media) throws Exception {
		super.init();
		String insertSQL = "insert into tb_media(title,src,picture,descript,uptime) values(?,?,?,?,?)";
		int flag = qRunner.update(conn, insertSQL, new Object[]{media.getTitle(),media.getSrc(),media.getPicture()
				,media.getDescript(),media.getUptime()});
		DbUtils.closeQuietly(conn); 
		return flag>0 ? true : false;
	}
}
