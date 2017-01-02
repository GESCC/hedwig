# Hedwig

##프로젝트 소개 및 설명


###빌드 요구사양
JDK 7+  
Maven 3.2.x+

###Getting Start
**Gabia API 등록**



1. 배포된 jar 파일을 다운받아 설치한다.

```shell
$ wget https://github.com/GESCC/hedwig/releases/download/v0.4.0/hedwig-0.4.0.tar
$ tar xvf hedwig-0.4.0.tar
$ cd hedwig-0.4.0
```

2. 기본 사용자 정보와 서비스 api 정보를 입력한 후 실행한다.

```shell
$ sudo java -jar hedwig-0.4.0-SNAPAHOT.jar --defaultEmail=UserEmail --defaultPassword=Password --defaultPhonenumber=PhoneNumber --api.key=Your API Key(gabia) --api.id=API id (gabia) --api.sendNumber=PhoneNumber
```

```shell
#exmaple
$ sudo java -jar hedwig-0.4.0-SNAPAHOT.jar --defaultEmail=test@hanmail.net --defaultPassword=test --defaultPhonenumber=01012345678 --api.key=dlyguich2hkxo57kebcel2 --api.id=test --api.sendNumber=01012345678
```

3. 메인 페이지에서 기본 사용자를 사용하거나 또는 회원가입을 하여 로그인한다.

4. SMS를 전송한다.

5. 관리자 페이지에서 전체 문자 기록을 확인할 수 있다.

##소개/시연 동영상


##사용한 오픈소스
Spring 4.1.1  
Spring Boot 1.4.2  
Aspectj 1.6.10  
SLF4J 1.6.6  
JUnit 4.12  
Jackson 1.9.13  
JQuery 1.12.0  
Bootstrap 3.3.2  
Unirest-java 1.4.9  
