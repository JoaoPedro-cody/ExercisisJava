package exercise08.model.entities;

import exercise08.model.exception.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double initialBalance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.initialBalance = initialBalance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount){
        initialBalance += amount;
    }

    public void withdraw(Double amount){
        validateWithdraw(amount);
        initialBalance -= amount;
    }

    private void validateWithdraw(double amount){
        if (amount > withdrawLimit){
            throw new BusinessException("The amount exceeds withdraw limit");
        }
        else if (amount > initialBalance){
            throw new BusinessException("Not enough balance");
        }
    }

}
