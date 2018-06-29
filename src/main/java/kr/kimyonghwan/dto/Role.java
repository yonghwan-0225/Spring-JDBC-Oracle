package kr.kimyonghwan.dto;

public class Role {
	StringBuilder st = new StringBuilder();
	private int Order_NO;
	private String NATION_ID;
	private String NATION_NAME;
	public int getOrder_NO() {
		return Order_NO;
	}
	public void setOrder_NO(int order_NO) {
		Order_NO = order_NO;
	}
	public String getNATION_ID() {
		return NATION_ID;
	}
	public void setNATION_ID(String nATION_ID) {
		NATION_ID = nATION_ID;
	}
	public String getNATION_NAME() {
		return NATION_NAME;
	}
	public void setNATION_NAME(String nATION_NAME) {
		NATION_NAME = nATION_NAME;
	}
	@Override
	public String toString() {
		st.append("Role : ");
		st.append("[Order_NO] : ").append(Order_NO);
		st.append(" [NATION_ID] : ").append(NATION_ID);
		st.append(" [NATION_NAME] : ").append(NATION_NAME);
		
		return st.toString();
	}

}
