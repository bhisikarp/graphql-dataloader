Application POC for GraphQL Java Dataloader. Sample query - 

{
    "status": "OK",
    "data": {
        "account": {
            "id": "1",
            "accountNumber": "3333333333",
            "device": null
        }
    }
}

Assumption : Mongo DB should contain 3 collections - Account, Customer and Device. Entities associated are defined in com.test.graphql.entity package