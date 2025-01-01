## 1.目录结构

```
<modules>
    <module>aurora_emby-start</module>
    <module>aurora_emby-application</module>
    <module>aurora_emby-domain</module>
    <module>aurora_emby-infrastructure</module>
    <module>aurora_emby-common</module>
    <module>aurora_emby-interfaces</module>
</modules>
```



#### 1. **aurora_emby-start**

- **作用**：通常，`start` 模块是一个启动模块，它可能包含应用的入口点（如 `main` 方法）。它负责初始化其他模块、配置项目的依赖和启动应用程序。这通常是项目的“主程序”或应用程序的启动配置部分。
- **功能**：包括应用程序的初始化、配置加载和服务启动等。

#### 2. **aurora_emby-application**

- **作用**：`application` 模块通常包含与应用程序的核心业务逻辑相关的代码。它通常会处理应用的流程和业务规则，比如调用其他模块提供的功能，进行数据处理和协调等。
- **功能**：负责具体的业务实现，可能包括服务、事务管理等。它与 `infrastructure` 和 `domain` 层交互。

#### 3. **aurora_emby-domain**

- **作用**：`domain` 模块是项目中的核心业务模型层，它应该包含应用程序的核心实体（如类和对象），以及业务逻辑的模型。例如，定义业务领域的对象和他们之间的关系。
- **功能**：包含与应用程序的业务逻辑相关的类（例如等），用于定义业务规则。通常不会包含任何外部框架或技术细节。

### 4. **aurora_emby-infrastructure**

- **作用**：`infrastructure` 模块包含了与底层基础设施相关的代码，例如数据库访问、文件存储、第三方 API 集成等。它通常与数据访问层、消息队列、网络通信等技术相关。
- **功能**：提供对外部系统的连接，处理持久化、网络通信、日志记录等工作。它为其他模块提供支持和服务。

#### 5. **aurora_emby-common**

- **作用**：`common` 模块包含项目中多个模块共享的通用功能、工具类、常量、配置文件等。这是一个为其他模块提供基础功能的模块。
- **功能**：通常包含共享的工具类、常量、配置文件、异常处理等，不应该包含具体的业务逻辑。

#### 6. **aurora_emby-interfaces**

- **作用**：`interfaces` 模块通常用于定义接口层，或者暴露应用程序对外的 API 接口。它包含应用程序对外提供服务的 API 定义，或者定义其他模块和服务之间的通信接口。
- **功能**：可能包含服务接口、控制器接口、DTO（数据传输对象）等。它是其他模块之间交互的契约层。

### 

这个目录结构采用了典型的分层架构，每个模块负责不同的职责，目的是使代码更模块化、可维护，并且可以方便地进行测试和扩展。具体来说，常见的分层职责如下：

- **启动和入口点**：`aurora_emby-start`
- **业务逻辑**：`aurora_emby-application`
- **核心领域模型**：`aurora_emby-domain`
- **基础设施**：`aurora_emby-infrastructure`
- **共享工具和常量**：`aurora_emby-common`
- **对外接口**：`aurora_emby-interfaces`