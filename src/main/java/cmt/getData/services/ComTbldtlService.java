package cmt.getData.services;


import java.util.List;

public interface ComTbldtlService {
	public List<?> selectExample(String sql);
	public List<?> selectMap(String sql);
	public List<?> selectExample(String sql,int current, int maxResult);
	public String sqlSum(String sql);
}
