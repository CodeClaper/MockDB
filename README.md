# MockDB
## What's this?
MockDB is a framework for test when you want to test your business code without relying on any real database.
## What you should know
1.  Although, MockDB has a nested memory database engine, but it is designed for real-time data manipulation, and it's not wise to use it in the production environment.
2. OutOfMemory error might can't be avoidable. These is no memory replacement strategy. So it just allocates new memory constantly until the device has not any memory.  In this way, It's not recommended to use it to test big data environment.
3. Memory always is faster than disk. So not use it to test performance that might be misleading.