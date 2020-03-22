package org.coronainfo.webscraper.scraper

import org.coronainfo.webscraper.Region
import org.json.JSONObject
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

abstract class CaseScraper {

    /**
     * Checks whether this scraper is capable of
     * retrieving the information matching
     * the provided filter
     *
     * @return `true` if this scraper matches the
     * provided filter, otherwise `false`
     */
    protected abstract fun verifyRegion(
        region: Region
    ): Boolean


    protected abstract fun getRequest(
        region: Region
    ): HttpRequest

    protected abstract fun decodeCases(jsonObject: JSONObject): Int?

    /**
     * @return The number of cases, `null` if this scraper
     * does not have any information for the provided
     * filters
     * @throws IllegalStateException If there was an error
     * retrieving the data
     */
    fun getCases(
        region: Region
    ): Int? {
        if (!verifyRegion(region)) {
            return null
        }
        val response: HttpResponse<String>
        response = try {
            HttpClient.newHttpClient()
                .send(
                    getRequest(region),
                    HttpResponse.BodyHandlers.ofString()
                )
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
        return if (response.statusCode() == 200) {
            decodeCases(JSONObject(response.body()))
        } else {
            System.err.println(response.body())
            null
        }
    }
}
