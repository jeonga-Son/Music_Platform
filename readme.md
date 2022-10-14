## 스프링부트 - 스프링 음원결제

### <프로젝트 세팅>


![img.png](img.png)

![img_2.png](img_2.png)

<br>

### <오류해결>
1. long cannot be dereferenced 에러

<br>

![img_1.png](img_1.png)

BaseEntity의 id값을 long에서 Long 타입으로 변경하니 오류 해결됨.