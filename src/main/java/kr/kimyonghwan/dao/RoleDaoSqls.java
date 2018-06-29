package kr.kimyonghwan.dao;

public class RoleDaoSqls {
	public static final String SELECT_ALL = "SELECT Order_NO , NATION_ID ,NATION_NAME FROM Nation order by Order_NO";
	public static final String UPDATE = "UPDATE Nation set NATION_NAME = :NATION_NAME where Order_NO = :Order_NO";
	public static final String SELECT_BY_ORDER_NO = "SELECT Order_NO, NATION_ID ,NATION_NAME FROM Nation where Order_NO = :Order_NO";
	public static final String DELETE_BY_ORDER_NO = "DELETE FROM nation where Order_NO = :Order_NO";
}
