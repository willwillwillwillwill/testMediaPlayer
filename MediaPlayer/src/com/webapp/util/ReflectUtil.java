package com.webapp.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReflectUtil {

    /**
     * �ѵ�һ����ĸת��Ϊ��д
     * 
     */
    public static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
    /**
     * ��ͷ��ĸתΪСд���Ż���
     * ע�⣺��Ŀ�ı�����po������Ӧ��һ��
     */
    public static String getTableName(String tableName) throws Exception{
        byte[] temp = tableName.getBytes();
        temp[0] = (byte) ((char) temp[0] +32);
        return new String(temp);
    }
    /**
     * ͨ��������֣��õ��������
     */
    public static List<Object> getPK(String tableName) throws SQLException{
        List<Object> list = new ArrayList<Object>();
        DBConn db = new DBConn();
        Connection connection = db.getConntion();
        DatabaseMetaData data = connection.getMetaData();
        ResultSet resultSet = data.getPrimaryKeys(Config.DATABASE_SID, Config.DATABASE_SID, tableName.toUpperCase());
        while (resultSet.next()) {
            list.add(resultSet.getObject(4));
        }
        return list;
    }
}
