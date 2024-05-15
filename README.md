<h1>공공 데이터 DB 저장 및 조회</h5>
<h2>과제 내용</h2>
<p>경기도 의정부시 문충로 74 지역의 단기예보 확인</p>
<h3>배운 점</h3>
<ul>
  <li>JSON 데이터 역직렬화시 처음 부분부터 시도할 것</li>
  <li>
    <p>JPA에서 카멜 케이스를 바탕으로 DB와 ENTITY의 변수명 일치시키지 말것</p>
    <p> => <B>스네이크 케이스를 활용할 것</B></p>
  </li>
</ul>
<h3>아쉬운 점</h3>
<ul>
  <li>
    <p>개인적으로 멀티모듈에 대해 공부하며 </p>
    <p>의존성 역전 원칙에 대해 알게 되면서 모듈의 연결 방식을</p>
    <p>application(controller) => domain(dto/service) <= repository(entity)</p>
    <p>위와 같이 구성하여 <b>entity와 dto의 시스템적으로 독립성</b>을 보장해보고 싶었으나</p>
    <p>프로젝트의 범위가 작다고 느껴 시도하지 않았다.</p>
    <p>혹여 다음 프로젝트를 하게 된다면 이런 부분을 신경 써보며 멀티 모듈 프로젝트를 구성할 것</p>
  </li>
</ul>
<h3>기술 스택</h3>
<ul>
  <li>JAVA</li>
  <li>Springboot</li>
  <li>MySQL</li>
  <li>JPA</li>
</ul>
<h3>구현 대상 API</h3>
<ul>
  <li>단기 예보 DB 저장 API(POST 요청)</li>
  <li>단기 예보 DB 조회 API(GET 요청)</li>
</ul>
<h3>주의 사항</h3>
<ul>
  <li>RestTemplate 사용, URLConnection 사용 X</li>
  <li>멀티 모듈을 활용</li>
  <ul><li>모듈을 최대한 작게, 느슨한 결합, 높은 응집도</li></ul>
</ul>



