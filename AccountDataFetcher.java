package com.test.graphql.fetchers;

import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import com.test.graphql.entity.Account;
import com.test.graphql.entity.Customer;
import com.test.graphql.entity.Device;

import graphql.schema.DataFetchingEnvironment;

@Component
public class AccountDataFetcher {
    public CompletableFuture<Account> getAccount(DataFetchingEnvironment env) {
        Long accountId = Long.parseLong(env.getArgument("accountId"));

        DataLoader<Long, Account> accountDataLoader = env.getDataLoader("AccountLoader");

        return accountDataLoader.load(accountId);
    }

	public CompletableFuture<Customer> getAccountCustomer(DataFetchingEnvironment environment) {
		Account account = environment.getSource();
		DataLoader<Long, Customer> customerDataLoader = environment.getDataLoader("CustomerLoader");

        return customerDataLoader.load(account.getCustomerId());
	}

	public CompletableFuture<Device> getAccountDevice(DataFetchingEnvironment environment) {
		Account account = environment.getSource();
		DataLoader<Long, Device> deviceDataLoader = environment.getDataLoader("DeviceLoader");

        return deviceDataLoader.load(account.getDeviceId());
	}
} 
