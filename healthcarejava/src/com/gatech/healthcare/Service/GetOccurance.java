package com.gatech.healthcare.Service;

import java.util.ArrayList;
import org.json.*;

import com.gatech.healthcare.DAO.DBAdapter;
import com.gatech.healthcare.DAO.Occur;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Get")
public class GetOccurance {
	@GET
	@Produces("application/json")
	public String Error() {

		return "{Error! Need Param}";
	}

	@Path("/VRE")
	@GET
	@Produces("application/json")
	public String getData() {
		DBAdapter db = new DBAdapter();
		ArrayList<Occur> occList = db.GetOccurVre();
		JSONObject jo = new JSONObject();
		jo.putOnce("Year", 2013);
		JSONArray ja = new JSONArray();
		JSONObject joMetric;
		for (Occur occ : occList) {
			joMetric = new JSONObject();
			joMetric.put("Case_Mix_Index", occ.case_Mix_Index);
			joMetric.put("Compared_To_Pooled_Mean_Rate", occ.compared_To_Pooled_Mean_Rate);
			joMetric.put("facilityName", occ.facilityName);
			joMetric.put("Incidence_Rate", occ.Incidence_Rate);
			joMetric.put("p95_Lower", occ.p95_Lower);
			joMetric.put("p95_Upper", occ.p95_Upper);
			
			ja.put(joMetric);
		}
		jo.put("metrics",ja);
		String res = jo.toString();
		return res;
	}
}
