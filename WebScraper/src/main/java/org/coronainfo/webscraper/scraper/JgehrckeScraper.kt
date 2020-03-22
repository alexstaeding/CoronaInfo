package org.coronainfo.webscraper.scraper

import org.coronainfo.webscraper.Region
import org.json.JSONObject
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.time.Duration

class JgehrckeScraper : CaseScraper() {

    private val mainUri = "http://covid19-germany.appspot.com/"

    override fun verifyRegion(
        region: Region
    ): Boolean {
        return region.country == "DE"
    }

    override fun getRequest(
        region: Region
    ): HttpRequest {
        return HttpRequest.newBuilder()
            .uri(URI(mainUri +
                if (region.province == null) "now" else "timeseries/DE-${region.province}/cases")
            )
            .version(HttpClient.Version.HTTP_2)
            .timeout(Duration.ofSeconds(15))
            .build()
    }

    override fun decodeCases(jsonObject: JSONObject): Int? {
        return jsonObject.optJSONObject("current_totals")?.getInt("cases") ?: {
            val a = jsonObject.getJSONArray("data")
            val b = a.getJSONObject(a.length() - 1)
            val it = b.keys()
            if (it.hasNext()) b.getInt(it.next()) else null
        }()
    }
}
