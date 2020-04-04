import org.jsoup.Jsoup;
import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class ezan_vakti {
   public static void main(String[] args) throws IOException {
	  System.setProperty("javax.net.ssl.trustStore", "your_keystore.jks");
	  String url = "https://namazvakitleri.diyanet.gov.tr/tr-TR/9227";
	  ArrayList<String> vakit_listesi = new ArrayList<>();
	  try{
      Document document = Jsoup.connect(url).get();
	  Element table = document.select("table").get(1);
	  
	  Elements trs = table.select("tr");
	  trs.remove(0);
	   for (Element tr : trs) {
            Elements tds = tr.getElementsByTag("td");
            // Element td = tds.first();
		for(Element td : tds)
			{
				System.out.println(td.text());
				vakit_listesi.add(td.text());
			}
        }

	  } catch (IOException e){e.printStackTrace();}
			System.out.println(vakit_listesi.get(0));
			System.out.println(vakit_listesi.get(1));
			System.out.println(vakit_listesi.get(2));
   }
}