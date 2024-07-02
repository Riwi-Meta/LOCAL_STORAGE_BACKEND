package com.riwi.localstorage.riwi_local_storage.infrastructure.helpers;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
// import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PdfGenerator {

    /**
     * Generates a PDF from dynamic HTML content based on the received information.
     */
    public static ResponseEntity<byte[]> generatePdf(Map<String, String> salesData) {
        // Output stream to hold the generated PDF
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            // Generate HTML content
            StringBuilder htmlContent = new StringBuilder();
            htmlContent.append("<html><head><style>")
                    .append("body { font-family: Arial, sans-serif; }")
                    .append("h1 { color: black; }")
                    .append("h2 { color: black; }")
                    .append("p { margin: 0 0 10px; }")
                    .append("table { width: 100%; border-collapse: collapse; }")
                    .append("th, td { border: 1px solid black; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; }")
                    .append("</style></head><body>");

            // Adding title to the HTML content based on the provided dates
            if (salesData.get("Date2").equals("")) {
                htmlContent.append("<h1>Sales Report on " + salesData.get("Date1") + "</h1>");
            } else {
                htmlContent.append("<h1>Sales Report from " + salesData.get("Date1") + " to " + salesData.get("Date2")
                        + "</h1>");
            }

            htmlContent.append("<hr/>")
                    .append("<h2>Total Sales</h2>")
                    .append("<p>")
                    .append(salesData.get("TotalSales"))
                    .append("</p>")
                    .append("<h2>Best-Selling Product</h2>")
                    .append("<p>")
                    .append(salesData.get("Top1"))
                    .append("</p>")
                    .append("<h2>Top 10 Best-Selling Products</h2>")
                    .append("<p>")
                    .append(salesData.get("Top10"))
                    .append("</p>")
                    .append("</body></html>");

            // Configure and generate the PDF using the HTML content
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(htmlContent.toString(), "/");
            builder.toStream(out);
            builder.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Generate the PDF as a byte array
        ByteArrayInputStream pdfStream = new ByteArrayInputStream(out.toByteArray());

        // Read the content of the PDF into a byte array
        byte[] pdfBytes = new byte[0];
        pdfBytes = pdfStream.readAllBytes();

        // Configure the response headers to ensure the file is treated as a PDF and
        // forced to download
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=sales_report.pdf"); // Force download
        headers.add("Content-Type", "application/pdf"); // Ensure the content is treated as a PDF

        // Return the PDF in the response
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(pdfBytes);
    }
}

// Implementation example in a Service

// Important Note: In the map you should not change the value of the keys since
// it is with these that the tracking is being done
// to insert the information in the PDF, the only thing that should be changed
// at the time of implementation is the value
// of the content.

// @Service
// public class PruebaService {

// public ResponseEntity<byte[]> getAll() {
// // Example of the data to be included in the Map sent as a parameter
// Map<String, String> salesData = Map.of(
// // Here you must enter the initial date of the query or the unique
// // date that will be in the report in case it is only one day.
// "Date1", "29/06/2024",
// // Here you must enter the end date of the query or in case it is a
// // single day report you must enter an empty String
// "Date2", "02/07/2024",
// "TotalSales",
// "Here you can put information about sales or a total profit or whatever you
// want to show about total sales in this section, it will work as long as the
// value sent is in String format",
// "Top1",
// "here you can enter the information of the best selling product in the given
// date range or in the query of the given day <br/> Product A",
// "Top10",
// "here you can enter the information of the ten best selling products in the
// given date range or in the query of the given day <br/> Product A - if you
// want to make a line break you can do it with the HTML tag br, <br/> Product
// B, <br/> Product C, <br/> Product D, <br/> Product E, <br/> Product F,
// otherwise it will be concatenated in one line -> Product G, Product H,
// Product I, Product J");

// // Return the PDF in the response
// return PdfGenerator.generatePdf(salesData);
// }
// }
