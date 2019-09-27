package com.stress.test.demo;

import org.springframework.util.StringUtils;

import java.sql.*;

public class Demo01 {
  public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

     /*   spring.datasource.url=jdbc:mysql://192.168.20.129:3309/CF_TEST_DB?useSSL=false
    spring.datasource.username=root
        spring.datasource.password=Management123!@#
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver*/
        String url = "jdbc:mysql://192.168.20.129:3309/CF_TEST_DB?useUnicode=true&characterEncoding=utf-8";
        Connection conn = DriverManager.getConnection(url, "root", "Management123!@#");
        Statement stat = conn.createStatement();


        //查询数据
        ResultSet result = stat.executeQuery("SELECT table_name name FROM information_schema.TABLES where table_schema='CF_DB'");
        while (result.next())
        {


         /*    <table tableName="ACC_META"  domainObjectName="BaseAccMeta" enableCountByExample="false" enableUpdateByExample="false"
            enableDeleteByExample="false" enableSelectByExample="false" selectByExampleQueryId="false">
		    <generatedKey column="ID" sqlStatement="Mysql" identity="true"/>
	   	</table>*/
         StringBuilder stringBuilder=new StringBuilder();

         stringBuilder.append("<table tableName=\"");
         stringBuilder.append(result.getString("name"));
         stringBuilder.append("\"  domainObjectName=\"Base");
         stringBuilder.append(upperTable(result.getString("name").toString().toLowerCase()));
         stringBuilder.append("\" enableCountByExample=\"false\" enableUpdateByExample=\"false\"\n" +
                 "            enableDeleteByExample=\"false\" enableSelectByExample=\"false\" selectByExampleQueryId=\"false\">\n" +
                 "\t\t    <generatedKey column=\"ID\" sqlStatement=\"Mysql\" identity=\"true\"/>");
         stringBuilder.append("</table>");

            System.out.println(stringBuilder );
        }

        //关闭数据库
        result.close();
        stat.close();
        conn.close();
    }

    public static String upperTable(String str)
    {
        // 字符串缓冲区
        StringBuffer sbf = new StringBuffer();
        // 如果字符串包含 下划线
        if (str.contains("_"))
        {
            // 按下划线来切割字符串为数组
            String[] split = str.split("_");
            // 循环数组操作其中的字符串
            for (int i = 0, index = split.length; i < index; i++)
            {
                // 递归调用本方法
                String upperTable = upperTable(split[i]);
                // 添加到字符串缓冲区
                sbf.append(upperTable);
            }
        } else
        {// 字符串不包含下划线
            // 转换成字符数组
            char[] ch = str.toCharArray();
            // 判断首字母是否是字母
            if (ch[0] >= 'a' && ch[0] <= 'z')
            {
                // 利用ASCII码实现大写
                ch[0] = (char) (ch[0] - 32);
            }
            // 添加进字符串缓存区
            sbf.append(ch);
        }
        // 返回
        return sbf.toString();
    }

}
