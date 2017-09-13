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

### Web Services' callings:
___

#### **Billing Inquiry**

**1) GetFileNetDocByDateRange** <br/>
http://localhost:8080/BillingInquiry/GetFilenetDocByDateRange<br/>
Method: POST<br/>
Parameters (application/json media type):
```json
{
   "fromDate" : "2015-01-01",
   "toDate" : "2017-09-07",
   "agencyCode": 32000
}
```

**2) GetBillingData** <br/>
http://localhost:8080/BillingInquiry/GetBillingData<br/>
Method: POST<br/>
Parameters (application/json media type)
```json
{
    "agencyCode": "32000",
    "policyKey": 423193
}
```

**3) GetPolicyDetail** <br/>
http://localhost:8080/BillingInquiry/GetPolicyDetail<br/>
Method: POST<br/>
Parameters (application/json media type):
```json
{
    "agencyCode": "72500",
    "policyKey": 100320
}
```
___

#### **Insured Billing**

**1) RecentPayments** <br/>
http://localhost:8080/InsuredBilling/RecentPayments/<b>{clientId}</b><br/>
i.e.<br/>
[http://localhost:8080/InsuredBilling/RecentPayments/21308]<br/>
Method: GET<br/>

**2) InsuredAuditQuery** <br/>
http://localhost:8080/InsuredBilling/InsuredAuditQuery/<b>{clientId}</b><br/>
i.e.<br/>
http://localhost:8080/InsuredBilling/InsuredAuditQuery/80495<br/>
Method: GET<br/>

**3) PolicyStatus** <br />
http://localhost:8080/InsuredBilling/PolicyStatus/<b>{submissionNumber}</b><br />
i.e.<br/>
[http://localhost:8080/InsuredBilling/PolicyStatus/100320]<br/>
Method: GET<br/>

**4) CurrentTotalPaid** <br />
http://localhost:8080/InsuredBilling/CurrentTotalPaid/<b>{submissionNumber}</b><br />
i.e.<br/>
[http://localhost:8080/InsuredBilling/CurrentTotalPaid/100320]<br/>
Method: GET<br/>

___


#### **AuditInquiry**

**1) interimAudit**<br />
http://localhost:8080//AuditInquiry//interimAudit/<b>{submissionNum}</b><br />
i.e.<br />
[http://localhost:8080//AuditInquiry//interimAudit/110457]<br />
Method: GET<br />

**2) InterimAudit2**<br />
http://localhost:8080//AuditInquiry//interimAudit2/<b>{submissionNum}/{submissionNum2}</b><br />
i.e.<br />
[http://localhost:8080//AuditInquiry//interimAudit2/110457/576382]<br />