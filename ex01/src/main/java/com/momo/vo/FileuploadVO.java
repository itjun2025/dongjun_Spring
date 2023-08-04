package com.momo.vo;

import lombok.Data;

@Data
public class FileuploadVO {
	private String uuid;
	private String uploadpath;
	private String filename;
	private String filetype;
	private int com_bno;
	
	private String savePath;
	private String s_savePath;
	
	//저장된 파일경로
	//uploadpath + uuid + "_" + filename;
}
