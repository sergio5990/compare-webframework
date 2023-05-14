| web framework             | jar size  | startup time | mem start | cpu start | load memory | load cpu | latency c50 | latency c100 | latency c200  |
|---------------------------|-----------|--------------|-----------|-----------|-------------|----------|-------------|--------------|---------------|
| spring-boot-reactive-kt   | 26.8mb    | 1.8s         | 120mb     | 34%       | 300mb       | 11%      | 4.082 ms    | 6.908 ms     | 15.600 ms fc  |
| spring-boot-reactive-java | 20.2mb    | 1.4s         | 70mb      | 34%       | 160mb       | 14%      | 4.756 ms    | 8.325 ms     | 18.864 ms fc  |
| spring-boot-servlet       | 17.6mb    | 1.68s        | 60mb      | 36%       | 300mb       | 20%      | 7.799 ms    | 11.628 ms    | 22.307 ms fc  |
| quarkus                   | 608b+36mb | ~1s          | 22mb      | ?2%       | 170mb       | 23%      | 4.907 ms    | 13.228 ms    | 16.669 ms fc  |
| micronaut                 | 14mb      | 630ms        | 30mb      | 13%       | 115mb       | 18%      | 4.004 ms    | 13.076 ms    | 16.258 ms fc  |
| klite                     | 7mb       | ?            | 12mb      | 6,7%      | 300mb       | 12%      | 11.738 ms   | 21.629 ms fc | 36.309 ms fc  |
| reactor-netty             | 6.7mb     | 0.4s         | 12mb      | 4.7%      | 60mb        | 10%      | 3.080 ms    | 7.011 ms     | 15.408 ms fc  |
| jooby-utow                | 4.8mb     | ?            | 25mb      | 8.2%      | 56mb        | 11%      | 3.704 ms    | 7.948 ms     | 18.402 ms fc  |
| ktor                      | 13.7mb    | ?            | 14mb      | 5.2%      | 60mb        | 17%      | 9.549 ms    | 17.706 ms    | 32.010 mc fc  |
| sparkjava                 | 3.1mb     | ?            | 12mb      | 3,7%      | 92mb        | 17%      | 3.825 ms    | 8.658 ms fc  | 110.147 ms fc |
| vertx                     | 10mb      | ?            | 17mb      | ?2.6%     | 211mb       | 8%       | 3.187 ms    | 6.757 ms     | 14.834  ms fc |

fc - Failed requests


example build  
cd spring-reactive-kt
./gradlew  clean  build -x test

example run
cd build/libs/
java -jar demo-0.0.1-SNAPSHOT.jar

load test 
ab -n2000 -c50 -r 127.0.0.1:8080/hello

test final

| framework     | docker size | startup time | latency / rps c20             | latency c50                   | latency c100                      |
|---------------|-------------|--------------|-------------------------------|-------------------------------|-----------------------------------|
| klite         | 51.86 MB    | 4.1 s        | 53.338 [ms] / 374.96 [#/sec]  | 109.823 [ms] / 455.28 [#/sec] | 186.915 [ms] / 535.00 [#/sec]     |
| vertx         | 51.56 MB    | 2.0 s        | 32.434 [ms] / 616.64 [#/sec]  | 64.959 [ms] / 769.72 [#/sec]  | 90.815 [ms] / 1101.14 [#/sec]  2k |
| reactor-netty | 51.92 MB    | 2.6 s        | 35.948 [ms] / 556.36 [#/sec]  | 64.723 [ms] / 772.52 [#/sec]  | 86.075 [ms] / 1161.78 [#/sec]  2k |

./gradlew shadowJar
docker-compose build
docker-compose up


