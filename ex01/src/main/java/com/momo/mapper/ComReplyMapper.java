package com.momo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.momo.vo.ComReplyVO;

public interface ComReplyMapper {
	
	public List<ComReplyVO> getList();
	
	public List<ComReplyVO> replydate();
	
	public int insert(ComReplyVO vo);
	public int delete(int R_NO);
	
	public int update(ComReplyVO com_bno);
	
	public int replyupdate(ComReplyVO com_bno);
	
	
	
	public List<ComReplyVO> getMyReplies(@Param("com_bno") int com_bno);
	
	public ComReplyVO getone(int R_NO); 
	
	public int getTotalCnt();
	
	public int getCom_bnoCnt(int R_NO);

}
