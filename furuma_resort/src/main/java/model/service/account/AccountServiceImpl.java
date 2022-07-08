package model.service.account;

import model.repository.account.AccountRepository;

public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository = new AccountRepository();

    @Override
    public boolean account(String userName, String password) {
        return accountRepository.checkLogin(userName, password);
    }
}
