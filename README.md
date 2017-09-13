# billing-inquiry
## Application that exposes Billing Inquiry web services.

Let's take into account that Maven and Git will be needed as well as Java 8.

In order to compile and run the application, please:

1. Clone the project using https://github.com/Marco-Jojojo/billing-inquiry.git
2. Once the code is downloaded, execute:
    * the ./settings/addSqlServerDriver.bat file, to add the sql-driver jar file to our Maven local repository
    * mvn clean package (This will create the jar file)
3. This jar file can be executed with one of the following commands:
    1. java -jar target/BillingInquiry-1.0-SNAPSHOT.jar
    2. mvn spring-boot:run
    3. Directly from the IDE
4. The application will be exposed in http://localhost:8080/

### Examples of WS callings:

    http://localhost:8080/BillingInquiry/GetFilenetDocByDateRange
    Method: POST
    Parameters (application/json media type):
    {
        "fromDate" : "2015-01-01",
        "toDate" : "2017-09-07",
        "agencyCode": 32000
    }

    http://localhost:8080/BillingInquiry/GetBillingData
    Method: POST
    Parameters (application/json media type):
    {
        "agencyCode": "32000",
        "policyKey": 423193
    }
    
    http://localhost:8080/BillingInquiry/GetPolicyDetail
    Method: POST
    Parameters (application/json media type):
    {
        "agencyCode": "72500",
        "policyKey": 100320
    }
    
    http://localhost:8080/InsuredBilling/RecentPayments/{clientId}
    i.e.
    http://localhost:8080/InsuredBilling/RecentPayments/21308
    Method: GET
    
    http://localhost:8080/InsuredBilling/InsuredAuditQuery/{clientId}
    i.e.
    http://localhost:8080/InsuredBilling/InsuredAuditQuery/80495
    Method: GET

