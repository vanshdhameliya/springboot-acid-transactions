# ACID Properties in Spring Boot 🔬

This project demonstrates how **ACID properties** (Atomicity, Consistency, Isolation, and Durability) are implemented and managed using **Spring Boot**, **Spring Data JPA**, and the `@Transactional` annotation.

---

### 🏛️ ACID Properties Implementation

#### 1. Atomicity ("All-or-Nothing")
Ensured by the `@Transactional` annotation. When a multi-step operation (e.g., a banking transfer) runs, any unexpected `RuntimeException` triggers an automatic rollback. Either all database operations succeed together, or the entire transaction resets to its original state.
```java
@Transactional // Ensures Atomicity
public void transferMoney(Long fromId, Long toId, Double amount) {
    accountRepository.debit(fromId, amount);
    // If an error happens here, the debit is rolled back completely
    accountRepository.credit(toId, amount);
}
```

#### 2. Consistency (Data Integrity)
Maintained by enforcing business logic and database constraints (e.g., preventing a balance from going below zero). If a transaction attempts to save data that violates these rules, Spring Data JPA throws an exception and aborts the operation, keeping the database in a permanently valid state.

#### 3. Isolation (Concurrency Control)
Managed by configuring transaction isolation levels. This controls how changes made by one transaction are visible to other concurrent transactions, preventing issues like dirty reads, non-repeatable reads, or race conditions.
```java
@Transactional(isolation = Isolation.READ_COMMITTED) // Prevents Dirty Reads
public void processConcurrentUpdate() {
    // Isolated database logic here
}
```

#### 4. Durability (Permanence)
Guaranteed by the underlying transactional database engine. Once Spring successfully commits a transaction, the changes are written to non-volatile storage (disk via Write-Ahead Logs), ensuring the data survives sudden application crashes or server power losses.
