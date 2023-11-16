# Process bets and calculate winnings

## Description

This is a simple application that processes bets and calculates winnings.
Process two files with transactions and matches and calculate winnings for each user.
Aggregated winnings are stored in a file.

## Sample input

`player_data.txt`

```plaintext
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,DEPOSIT,,4000,
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,abae2255-4255-4304-8589-737cdff61640,500,A
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,a3815c17-9def-4034-a21f-65369f6d4a56,200,A
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,2b20e5bb-9a32-4d33-b304-a9c7000e6de9,100,A
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,de0785e2-58cb-413c-8e4b-1d135857733b,300,B
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,292b3cd6-b463-4c98-94a7-468e03740af0,500,A
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,f407bca9-cf69-4343-a489-6cee72384297,50,A
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,WITHDRAW,,200,
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,WITHDRAW,,1000,
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4,BET,d6c8b5a4-31ce-4bf8-8511-206cfd693440,50,A
4925ac98-833b-454b-9342-13ed3dfd3ccf,DEPOSIT,,400,
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,0037ae59-61ea-46c3-88a8-8ca705acde10,20,B
4925ac98-833b-454b-9342-13ed3dfd3ccf,DEPOSIT,,100,
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,5de45517-4312-4596-9702-9277b6d649f2,30,B
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,5936bc82-8d80-46e1-a583-f4477a68896e,50,B
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,5cbed318-af08-4046-947e-8e08b9f199c6,40,A
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,45571462-4c54-4dc7-beb2-8d143d1c6f90,10,A
4925ac98-833b-454b-9342-13ed3dfd3ccf,BET,f6ffad45-a63f-448b-9a14-ec8a10c77a45,33,A
4925ac98-833b-454b-9342-13ed3dfd3ccf,WITHDRAW,,8093,
```

`match_data.txt`

```plaintext
abae2255-4255-4304-8589-737cdff61640,1.45,0.75,A
a3815c17-9def-4034-a21f-65369f6d4a56,4.34,0.23,B
2b20e5bb-9a32-4d33-b304-a9c7000e6de9,0.54,1.85,DRAW
de0785e2-58cb-413c-8e4b-1d135857733b,0.67,1.52,DRAW
292b3cd6-b463-4c98-94a7-468e03740af0,1.23,0.79,B
f407bca9-cf69-4343-a489-6cee72384297,3.23,0.31,B
d6c8b5a4-31ce-4bf8-8511-206cfd693440,0.88,1.17,B
0037ae59-61ea-46c3-88a8-8ca705acde10,2.43,0.41,B
5de45517-4312-4596-9702-9277b6d649f2,1.21,0.82,DRAW
5936bc82-8d80-46e1-a583-f4477a68896e,0.12,7.21,A
5cbed318-af08-4046-947e-8e08b9f199c6,1.32,0.74,A
45571462-4c54-4dc7-beb2-8d143d1c6f90,4.23,0.21,B
f6ffad45-a63f-448b-9a14-ec8a10c77a45,6.76,0.13,A
```

## Sample output

result.txt
```plaintext
163f23ed-e9a9-4e54-a5b1-4e1fc86f12f4 2725 0.14

4925ac98-833b-454b-9342-13ed3dfd3ccf WITHDRAW null 8093 null

75
```

# Author

`Fullname : Nikita Kašnikov`

# Prerequisites

- JDK 17

# How to run

 Navigate to the project root folder and run the following command:

```shell
javac -d ./out src/*.java && java -classpath ./out:./resources Main
```

Then you can find the result in the `result.txt` file in the project source folder.