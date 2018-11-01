package com.webapp.dao;

import com.webapp.dao.impl.MediaDaoImpl;

public class DaoFactory { //����ģʽ,����Dao����,����ӿڱ��,����ʵ��ҵ��ӿڶ���Ķ���
    
    private static DaoFactory daoFactory = new DaoFactory();
    
    //�������ģʽ, ˽�й���,�����ṩ��ȡ�����Ķ����Ψһ�ӿ�,
    private DaoFactory(){
        
    }
    
    public static DaoFactory getInstance(){
        return daoFactory;
    }
    
    public static MediaDao getMediaDao(){
        return new MediaDaoImpl();
    }

}
