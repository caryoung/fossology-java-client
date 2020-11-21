package org.polaris.fossology.client.request.report;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polaris.fossology.client.httpclient.HttpGetFileMethod;
import org.polaris.fossology.client.httpclient.HttpGetMethod;
import org.polaris.fossology.client.model.DefaultResponse;
import org.polaris.fossology.client.model.job.Job;
import org.polaris.fossology.client.model.report.ReportRequestBean;
import org.polaris.fossology.client.request.job.handler.GetJobsHandler;
import org.polaris.fossology.client.request.report.handler.GetReportHandler;
import org.polaris.fossology.client.util.Consts;
import org.polaris.fossology.client.util.Utils;

public class ReportRequest {

	private static Logger logger = LogManager.getLogger(ReportRequest.class);

	public DefaultResponse get(ReportRequestBean requestBean) {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/report";
		HttpUriRequest request = new HttpGet(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		request.addHeader(Consts.UPLOAD_ID, "" + requestBean.getUploadId());
		request.addHeader("reportFormat", "" + requestBean.getReportFormat());
		String groupName = requestBean.getGroupName();
		if (!Utils.isEmpty(groupName)) {
			request.addHeader("groupName", requestBean.getGroupName());
		}

		HttpGetMethod<DefaultResponse> getMethod = new HttpGetMethod<DefaultResponse>();
		getMethod.setRequest(request);

		GetReportHandler handler = new GetReportHandler();
		getMethod.setHandler(handler);
		DefaultResponse response = getMethod.get();
		return response;

	}

	public DefaultResponse get(int reportId, String fileName) {
		String uri = Consts.FOSSOLOGY_URI + ":" + Consts.FOSSOLOGY_PORT + Consts.FOSSOLOGY_PATH + "/report/" + reportId;
		Request request = Request.Get(uri);
		request.addHeader(Consts.AUTHORIZATION, Consts.TOKEN);
		request.addHeader("accept", "text/plain");

		URL url = Thread.currentThread().getContextClassLoader().getResource(Consts.FILE_BASE + "/example.txt");
		String filePath = url.getPath();
		File f = new File(filePath);
		File f1;
		DefaultResponse responseBean = null;

		try {
			f1 = f.getCanonicalFile();
			File f2 = f1.getCanonicalFile();
			logger.info(f2);
			File destFile = new File(f2.getCanonicalPath()+"/"+fileName);
			logger.info(destFile);
			
			HttpGetFileMethod<DefaultResponse> getMethod = new HttpGetFileMethod<DefaultResponse>();
			getMethod.setRequest(request);
			getMethod.setFile(destFile);
			responseBean = getMethod.getFiles();
		} catch (IOException e) {
			logger.error(e, e);
		}
		return responseBean;

	}
}
