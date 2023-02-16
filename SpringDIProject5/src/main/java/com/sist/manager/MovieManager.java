package com.sist.manager;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import com.sist.vo.*;
import java.util.*;
import java.io.*;
import java.net.*;
@Component("mm") //https://www.kobis.or.kr/kobis/business/main/main.do
/*
 *  일일 박스오피스 : searchMainDailyBoxOffice.do
 *  실시간 예매율 : searchMainRealTicket.do
 *  좌석점유율순위 : searchMainDailySeatTicket.do
 *  온라인상영관 일일 : searchMainOnlineDailyBoxOffice.do
 */
public class MovieManager {
	/*public static void main(String[] args) {
		MovieManager m =new MovieManager();
		List<MovieVO> list=m.movieListData(1);
		System.out.println(list);
		for(MovieVO vo :list)
		{
			System.out.println(vo.getRank()+" "+vo.getTitle()+" "+vo.getGenre()+" "+vo.getDirector());
		}
	}*/
	private String[] strUrl= {"searchMainDailyBoxOffice.do","searchMainRealTicket.do",
			               "searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
	
	public List<MovieVO> movieListData(int no)
	{
		List<MovieVO> list=new ArrayList<MovieVO>();
		/*try
		{
			URL url=new URL("https://www.kobis.or.kr/kobis/business/main/"+strUrl[no]);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			if(conn!=null)
			{
				BufferedReader br=
						new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true)
				{
					String data=br.readLine();
					if(data==null) break;
					System.out.println(data);
				}
			}
		}catch(Exception ex) {}*/
		try
		{
			Document doc=Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/"+strUrl[no]).get();
			String data=doc.toString(); 
			data=data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
			data=data.replace("<", "");
			data=data.replace(">", "");
			//System.out.println(data);
				
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(data);
			/*
			 *  JSONArray ==> [] => ArrayList
			 *  JSONParser ==> {} => 객체
			 *  [{},{},{},{},{}...]
			 */
			// ["a","b","c"] => String [{},{},{}] JSONObeject
			for(int i=0;i<arr.size();i++)
			{
				JSONObject obj=(JSONObject)arr.get(i);
				MovieVO vo= new MovieVO();
				String rank=String.valueOf((long)obj.get("rank"));
				vo.setRank(Integer.parseInt(rank));
				vo.setTitle((String)obj.get("movieNm"));
				vo.setDirector((String)obj.get("director"));
				vo.setGenre((String)obj.get("genre"));
				list.add(vo);
			}
			
			//System.out.println(doc.toString());
		}catch(Exception ex) {}
		return list;
	}
}
