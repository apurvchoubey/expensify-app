This Spring Boot application retrieves vendor information and associated transactions from a third-party expense management system like Expensify. It leverages Expensify's Integration Server API to interact with the system programmatically.
Here's how it works:

1. Configuration: The application is configured with Expensify API credentials and connects to a MongoDB database.
2. Scheduled Data Pull: A scheduled task periodically fetches data from Expensify.
3. Expensify API Calls: The application utilizes the ExpensifyClient class to interact with the Expensify API. This client makes authenticated requests to retrieve:
4. Vendor List: It retrieves a list of vendors using the appropriate Expensify API endpoint. (Note: Due to limitations in the current Expensify API documentation, the specific endpoint for fetching vendors might require further investigation.)
Transactions per Vendor: For each vendor, it retrieves a list of associated transactions using another Expensify API endpoint. (Similar to the vendor list, the specific endpoint for transactions might require exploration beyond the official documentation.)
5. Data Storage: The retrieved vendor data, including the list of transactions for each vendor, is stored in a MongoDB database using Spring Data MongoDB repositories.

Important Note:
The current Expensify API documentation can be challenging to navigate, particularly when searching for specific endpoints related to vendor and transaction data retrieval. 
Hence this is a just a basic example and not a fully fledged running application as the documentation is pretty unclear and needs further improvements.
