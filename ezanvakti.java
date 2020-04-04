import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ezanvakti {
   public static void main(String[] args) throws IOException 
   {
	  HttpHandler sh = new HttpHandler();
	  String url = "https://ezanvakti.herokuapp.com/vakitler?ilce=9227";
	  String jsonStr = sh.makeServiceCall(url);
	  ArrayList<HashMap<String, String>> vakitList;
	  vakitList = new ArrayList<>();
	  if (jsonStr != null)
	  {
		  try
		  {
			  JSONObject jsonObj = new JSONObject(jsonStr);
			  JSONArray vakitler = jsonObj.getJSONArray("");	// bunu kaldırma ihtiyacı olbilir
			  for (int i = 0; i < vakitler.length(); i++)
			  {
				  JSONObject v = vakitler.getJSONObject(i);
				  String miladi_tarih = v.getString("MiladiTarihUzun");
				  String hicri_tarih = v.getString("HicriTarihUzun");
				  String imsak = v.getString("Imsak");
				  String gunes = v.getString("Gunes");
				  String ogle = v.getString("Ogle");
				  String ikindi = v.getString("Ikindi");
				  String aksam = v.getString("Aksam");
				  String yatsi = v.getString("Yatsi");
				  String kible_saati = v.getString("KibleSaati");
				  
				  HashMap<String, String> vakit = new HashMap<>();
				  vakit.put("miladi_tarih",miladi_tarih);
				  vakit.put("hicri_tarih",hicri_tarih);
				  vakit.put("imsak",imsak);
				  vakit.put("gunes",gunes);
				  vakit.put("ogle",ogle);
				  vakit.put("ikindi",ikindi);
				  vakit.put("aksam",aksam);
				  vakit.put("yatsi",yatsi);
				  vakit.put("kible_saati",kible_saati);
				  
				  vakitList.add(vakit);
			  }
		  } catch (final JSONException e) {e.printStackTrace();}
		  System.out.println(vakitList.get(0));
	  }
	  
   }
}
/*
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        String id = c.getString("id");
                        String name = c.getString("name");
                        String email = c.getString("email");
                        String address = c.getString("address");
                        String gender = c.getString("gender");

                        // Phone node is JSON Object
                        JSONObject phone = c.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id", id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);

                        // adding contact to contact list
                        contactList.add(contact);
*/