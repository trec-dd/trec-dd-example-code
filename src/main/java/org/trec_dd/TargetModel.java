package org.trec_dd;

import java.util.HashMap; 


/*
* Proposed schema by IST:
*
*	"url" : "",
*	"timestamp": "",
*	"request": {
*				"method": "",
*				"client": {
*							"hostname": "",
*							"address": "",
*							"software": "",
*							"robots": "",
*							"contact": {
*										"name": "",
*										"email": "",
*										},
*							},
*				"headers": {
*							"Accept": "",
*							"Accept-Encoding": "",
*							"Accept-Language": "",
*							"User-Agent": "",
*							},
*				"body": null,
*				},
*	"response": {
*				"status": "",
*				"server": {
*							"hostname": "",
*							"address": "",
*						  },
*				"headers": {
*							"Content-Encoding": "",
*							"Content-Type": "",
*							"Date": "",
*							"Expires": "",
*							"Server": "",
*							},
*				"body": "",
*				},
*	"key": "",
*	"imported": "",
*/

public class TargetModel {
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public HashMap<String, Object> getRequest() {
		return request;
	}

	public void setRequest(HashMap<String, Object> request) {
		this.request = request;
	}

	public HashMap<String, Object> getResponse() {
		return response;
	}

	public void setResponse(HashMap<String, Object> response) {
		this.response = response;
	}

	public String getUrl() {
		return url;
	}

	public String getKey() {
		return key;
	}
	
	public String url;
	public String key;
	public long timestamp;
	public HashMap<String, Object> request;
	public HashMap<String, Object> response;

	public TargetModel() {
		
	}

	
	public TargetModel(String contactName, String contactEmail){
		request = new HashMap<String, Object> ();
		response = new HashMap<String, Object> ();
		
		
		HashMap<String, Object> contact = new HashMap<String, Object> ();
		contact.put("name", contactName);
		contact.put("email", contactEmail);

		HashMap<String, Object> client = new HashMap<String, Object> ();
		client.put("software", "ACHE");
		client.put("contact", contact);

		HashMap<String, Object> headers = new HashMap<String, Object> ();
		headers.put("Accept-Language", "en-US,en");

		request.put("method", "GET");
		request.put("client", client);
		request.put("headers", headers);
		request.put("body", null);
	}

	public void setTimestamp() {
		this.timestamp = System.currentTimeMillis() / 1000L;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setKey(String shaKey) {
		this.key = shaKey;
	}
	
	public void setContent(String content) {
		this.response.put("body", content.replaceAll("(\r?\n)", " "));
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(getKey());
		sb.append(" ");
		sb.append(getUrl());
		sb.append("\n");
		sb.append(response.get("body"));
		return sb.toString();
	}
}
