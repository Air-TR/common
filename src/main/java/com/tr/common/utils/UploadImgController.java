//package com.tr.common.utils;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.tr.common.utils.exception.MyException;
//import com.tr.common.utils.result.Result;
//import com.tr.common.utils.result.ResultEnum;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
///**
// * 广告页控制类
// * 
// * @author taorun
// * @date 2017年8月29日 下午9:37:11
// *
// */
//
//@Api(tags = { "AdvertisingPage" })
//@RestController
//public class UploadImgController {
//
//	@Value(value = "${my.host}")
//	private String myHost;
//
//	/**
//	 * 上传图片
//	 * 返回示例：http://cpxxd.geroncloud.com/data/cpxx/img/81a1047d-ae66-4029-910e-ce80888538c7.jpeg
//	 * 注：参数若传入imgName，上传服务器的文件名即为传入的imgName，否则UUID生成唯一标识符作为文件名。
//	 * 
//	 * @param file
//	 * @param session
//	 * @return
//	 * @throws IllegalStateException
//	 * @throws IOException
//	 */
//	@ApiOperation(value = "上传图片")
//	@PostMapping(value = "/mgr/advertisingPage/uploadImg")
//	public Result<String> uploadIcon(@RequestParam MultipartFile file, @RequestParam(required = false) String imgName) throws IllegalStateException, IOException {
//		Result<String> res = new Result<>();
//		String url;
//		String prefix = "/home";
//		String dir;
//		File dirFile;
//		if (imgName != null && !imgName.equals("")) {
//			dir = "/data/cpxx/fixed-img/";
//			dirFile = new File(prefix + dir);
//			if (!dirFile.exists()) {
//				dirFile.mkdirs();
//			}
//			url = dir + imgName;
//			File dest = new File(prefix + url);
//			file.transferTo(dest);
//			url = myHost + url;
//		} else {
//			dir = "/data/cpxx/img/";
//			dirFile = new File(prefix + dir);
//			if (!dirFile.exists()) {
//				dirFile.mkdirs();
//			}
//			String originName = file.getOriginalFilename();
//			int i = originName.lastIndexOf(".");
//			String end = originName.substring(i); // 截取文件名后缀
//			url = dir + UUID.randomUUID().toString() + end;
//			File dest = new File(prefix + url);
//			file.transferTo(dest);
//			url = myHost + url;
//		}
//		res.setData(url);
//		return res;
//	}
//
//	/**
//	 * 上传图片，支持多张同时上传
//	 * 
//	 * @param files
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	@ApiOperation(value = "上传图片，支持多张同时上传")
//	@PostMapping(value = "/uploads")
//	public Result<List<String>> uploadImages(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws Exception {
//		String uploadPath = "...";
//		if (!FileUtilies.checkPathExist(uploadPath)) {
//			throw new MyException(ResultEnum.NO_EXIST_PATH); // 抛出不存在的路径异常
//		}
//		List<String> fileNames = new ArrayList<String>();
//		if (null != files && files.length > 0) {
//			// 遍历并保存文件
//			for (MultipartFile file : files) {
//				String originName = file.getOriginalFilename(); // 得到包含扩展名的文件名
//				String ext = FileUtilies.getExtensionName(originName); // 获取文件扩展名
//				String newFileName = UUIDUtilies.uuid() + "." + ext; // UUID生成新文件名
//				String fullPath = uploadPath + "/" + newFileName; // 完整路径
//				File dest = new File(fullPath);
//				file.transferTo(dest);
//				fileNames.add(newFileName);
//			}
//		}
//		return Result.success(fileNames);
//	}
//
//}
