（施工中）
# 使用说明
## 项目介绍
本项目是一个用于快速构建 Java 后端的脚手架项目
共有多个子项目，每个子项目都有一个单独的仓库
可按需要选择性地引入子项目

## 子项目介绍
### template-business-support


## 使用方法
### 下载项目
```shell
# git clone this project
```
### 删除脚手架项目的配置
#### git
删除 .git 文件夹

### 加载项目
使用代码编辑工具加载项目，推荐使用 IntelliJ IDEA,本文档基于 IntelliJ IDEA 示例

#### 重命名
pom.xml 文件修改maven的 group id 和 artifact id 及其他相关信息
```xml
    <groupId>top.autuan</groupId>
    <artifactId>template-business-support</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>template-business-support</name>
    <description>template-business-support</description>
```

在 Project 视图里使用 shift F6 重命名项目为你的项目名

rename base package

mvn clean install