# billing-inquiry
## Application that exposes Billing Inquiry web services.

Let's take into account that Maven, Tomcat 8+ and Git will be needed as well as Java 8.

In order to compile and run the application, please:

1. Clone the project using https://github.com/Marco-Jojojo/billing-inquiry.git
2. Once the code is downloaded, execute:
    * the ./settings/addSqlServerDriver.bat file, to add the sql-driver jar file to our Maven local repository
    * mvn clean package (This will create the war file)
3. This war file will need to be deployed in a Tomcat 8+
4. The application will be exposed in http://localhost:8080/pei

### Web Services' callings:
___

#### **Billing Inquiry**

**1) GetFileNetDocByDateRange** <br/>
http://localhost:8080/pei/BillingInquiry/GetFilenetDocByDateRange<br/>
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
http://localhost:8080/pei/BillingInquiry/GetBillingData<br/>
Method: POST<br/>
Parameters (application/json media type)
```json
{
    "agencyCode": "32000",
    "policyKey": 423193
}
```

**3) GetPolicyDetail** <br/>
http://localhost:8080/pei/BillingInquiry/GetPolicyDetail<br/>
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
http://localhost:8080/pei/InsuredBilling/RecentPayments/<b>{clientId}</b><br/>
i.e.<br/>
[http://localhost:8080/pei/InsuredBilling/RecentPayments/21308]<br/>
Method: GET<br/>

**2) InsuredAuditQuery** <br/>
http://localhost:8080/pei/InsuredBilling/InsuredAuditQuery/<b>{clientId}</b><br/>
i.e.<br/>
http://localhost:8080/pei/InsuredBilling/InsuredAuditQuery/80495<br/>
Method: GET<br/>

**3) PolicyStatus** <br />
http://localhost:8080/pei/InsuredBilling/PolicyStatus/<b>{submissionNumber}</b><br />
i.e.<br/>
[http://localhost:8080/pei/InsuredBilling/PolicyStatus/100320]<br/>
Method: GET<br/>

**4) CurrentTotalPaid** <br />
http://localhost:8080/pei/InsuredBilling/CurrentTotalPaid/<b>{submissionNumber}</b><br />
i.e.<br/>
[http://localhost:8080/pei/InsuredBilling/CurrentTotalPaid/100320]<br/>
Method: GET<br/>

___


#### **AuditInquiry**

**1) interimAudit**<br />
http://localhost:8080/pei/AuditInquiry/interimAudit/<b>{submissionNum}</b><br />
i.e.<br />
[http://localhost:8080/pei/AuditInquiry/interimAudit/110457]<br />
Method: GET<br />

**2) InterimAudit2**<br />
http://localhost:8080/pei/AuditInquiry/interimAudit2/<b>{submissionNum}/{submissionNum2}</b><br />
i.e.<br />
[http://localhost:8080/pei/AuditInquiry/interimAudit2/110457/576382]<br />