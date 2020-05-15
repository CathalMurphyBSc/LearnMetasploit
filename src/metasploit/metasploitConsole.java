package metasploit;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.msgpack.MessagePack;



public class metasploitConsole 
{
	static String urlString = "http://127.0.0.1:55552/api/1.1";

	
	public static Object readConsole(String authToken, String consoleNumber) 
	{
		try {
		
			HttpURLConnection  urlConn;
			Object consoleOutput = null;
			
			List<String> params = new ArrayList<String>();
			params.add("console.read");
			params.add(authToken);
			params.add(consoleNumber);
			//params.add("version\n");
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
			
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
	
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			
			
			
			 int responseCode = urlConn.getResponseCode();
			 
				if (responseCode == HttpURLConnection.HTTP_OK) 
				{
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					InputStream inStream = urlConn.getInputStream();
					
					byte[] buffer = new byte[1024];
					int len;
					
					while ((len = inStream.read(buffer)) != -1)
					{
						os.write(buffer, 0, len);
					}
					
					
					consoleOutput = msgpack.read(os.toByteArray());
								
					inStream.close();
					
			
				} else {
					System.out.println("POST request not worked");
				}
				return consoleOutput;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
			
	}
	
	public static Object destroyConsole(String authToken, String consoleNumber) 
	{
		try {
		
			HttpURLConnection  urlConn;
			Object consoleOutput = null;
			
			List<String> params = new ArrayList<String>();
			params.add("console.destroy");
			params.add(authToken);
			params.add(consoleNumber);
			//params.add("version\n");
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
			
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
	
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			
			
			
			 int responseCode = urlConn.getResponseCode();
			 
				if (responseCode == HttpURLConnection.HTTP_OK) 
				{
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					InputStream inStream = urlConn.getInputStream();
					
					byte[] buffer = new byte[1024];
					int len;
					
					while ((len = inStream.read(buffer)) != -1)
					{
						os.write(buffer, 0, len);
					}
					
					
					consoleOutput = msgpack.read(os.toByteArray());
								
					inStream.close();
					
			
				} else {
					System.out.println("POST request not worked");
				}
				
				return consoleOutput;

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				return null;
	}

	public static void writeConsole(String consoleCommand, String authToken, String consoleNumber) 

	{
		try {
			
		
			
			HttpURLConnection  urlConn;
			
			List<String> params = new ArrayList<String>();
			params.add("console.write");
			params.add(authToken);
			params.add(consoleNumber);
			params.add(consoleCommand + " \n");
			
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
					
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
	
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			
			
			
			 int responseCode = urlConn.getResponseCode();
			 
				if (responseCode == HttpURLConnection.HTTP_OK) 
				{
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					InputStream inStream = urlConn.getInputStream();
					
					byte[] buffer = new byte[1024];
					int len;
					
					while ((len = inStream.read(buffer)) != -1)
					{
						os.write(buffer, 0, len);
					}
					
					//System.out.print(os.toByteArray());
					
					Object consoleOutput = msgpack.read(os.toByteArray());
					
					//System.out.println(consoleOutput);
					
					
					
					inStream.close();
					
			
				} else {
					System.out.println("POST request not worked");
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static String createConsoleInstance(String authToken) 
	{
		try {
		
			HttpURLConnection  urlConn;
			Object consoleOutput = null;
			
			List<String> params = new ArrayList<String>();
			params.add("console.create");
			params.add(authToken);
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
					
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
	
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			
			
			
			 int responseCode = urlConn.getResponseCode();
			 
			 /*
			 System.out.println("POST Response Code:: " + responseCode);
	
				if (responseCode == HttpURLConnection.HTTP_OK) { //success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							urlConn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
	
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
				*/
			 
				if (responseCode == HttpURLConnection.HTTP_OK) 
				{
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					InputStream inStream = urlConn.getInputStream();
					
					byte[] buffer = new byte[1024];
					int len;
					
					while ((len = inStream.read(buffer)) != -1)
					{
						os.write(buffer, 0, len);
					}
					
					//System.out.print(os.toByteArray());
					
					consoleOutput = msgpack.read(os.toByteArray());				
					inStream.close();
					
			
				} else {
					System.out.println("POST request not worked");
				}
				
				String consoleId = null;
				char[] response = consoleOutput.toString().toCharArray();
				for(int i = 1 ; i != response.length ; i++)
				{
					int charactersRemaining = response.length - i;
					if( charactersRemaining > 5 )
					{
						if (response[i] == 'i' && response[i+1] == 'd' )
						{
							consoleId = response[i+5] + "";
						}
					}
						
				}
				
				
			return consoleId;
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	
	public static Object listConsole(String authToken) 
	{
		try {
			
			
			
			HttpURLConnection  urlConn;
			Object consoleOutput = null;
			
			List<String> params = new ArrayList<String>();
			params.add("console.list");
			params.add(authToken);
			
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
					
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
	
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			
			
			
			 int responseCode = urlConn.getResponseCode();
			 
				if (responseCode == HttpURLConnection.HTTP_OK) 
				{
					ByteArrayOutputStream os = new ByteArrayOutputStream();
					InputStream inStream = urlConn.getInputStream();
					
					byte[] buffer = new byte[1024];
					int len;
					
					while ((len = inStream.read(buffer)) != -1)
					{
						os.write(buffer, 0, len);
					}
					
					//System.out.print(os.toByteArray());
					
					 consoleOutput = msgpack.read(os.toByteArray());
					
					//System.out.println(consoleOutput);
					
					
					
					inStream.close();
					
			
				} else {
					System.out.println("POST request not worked");
				}
			
				return consoleOutput;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}
	
	public static String authToken() 
	{
		try {
		
			HttpURLConnection  urlConn;
			
			String auth = "";
			
			
			List<String> params = new ArrayList<String>();
			params.add("auth.login");
			params.add("user");
			params.add("123");
			//params.add("console.list");
			//params.add("TEMP4k8mpQL4n7XIpPQmOcpbqXKYI6AW");
			
			
			
			MessagePack msgpack = new MessagePack();
			byte[] query = msgpack.write(params);
					
			URL mUrl = new URL(urlString);
			urlConn = (HttpURLConnection) mUrl.openConnection();
			
			urlConn.setDoOutput(true);
		
			urlConn.addRequestProperty("Content-Type", "binary/message-pack");
			if(query != null) {
				urlConn.getOutputStream().write(query);
			}
			 int responseCode = urlConn.getResponseCode();
			 //System.out.println("POST Response Code:: " + responseCode);
		
				if (responseCode == HttpURLConnection.HTTP_OK) { //success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							urlConn.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
		
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();
		
			
					
					
					String responseString = response.toString();
					char[] responseArray = responseString.toCharArray();
					
				
					for(int i = 1 ; i != responseArray.length ; i++)
					{
						
						
						int charactersRemaining = responseArray.length - i;
						if( charactersRemaining > 5 )
						{
							if(responseArray[i] == 'T' & responseArray[i+1] == 'E' & responseArray[i+2] == 'M' & responseArray[i+3] == 'P')
							{
								
								for (int x = i ; x != responseArray.length ; x ++)
								{
									auth = auth + responseArray[x];
								}
							}
						}
					}
				
					
					
					
					
					//System.out.println(response.toString());
				} else {
					System.out.println("POST request not worked");
				}
				return auth;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		}
	
	
	
	
	public static void consoleInterface(String input, String consoleNumber) 
	{
		try {
			
			if(input != null)
			{
				//System.out.println(jsonParser(consoleNumber));
				
				if (input != "exit")
				{
					writeConsole(input, authToken(),consoleNumber);
					//System.out.println(readConsole(authsToken(), consoleNumber));
					//return(jsonParser(consoleNumber));
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		public static Object consoleResponse(String consoleNumber) 
		{
			try {
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(readConsole(authToken(), consoleNumber).toString());
				//System.out.println(json.get("data"));
				
				return(json.get("data"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		
		public static Object deleteConsoleResp(String consoleNumber) 
		{
			try {
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(destroyConsole(authToken(), consoleNumber).toString());
				//System.out.println(json.get("data"));
				
				return(json.get("data"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		
	
	
	
}


