package com.momo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.momo.vo.RecFileVO;

@Service
public interface RecFileService {

	public List<RecFileVO> getList(int bno);
	
	public int insert(RecFileVO vo);
	
	public int fileupload(List<MultipartFile> files, int bno) throws Exception;
}
