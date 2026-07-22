# Cognizant Digital Nurture — Java FSE — Week 1 (Deepskilling)

Topics: Design Patterns · Data Structures & Algorithms · Advanced SQL · JUnit & Mockito

Everything here is **pure Java** — no other language required. (Note: the "NUnit/Moq"
naming is the .NET equivalent of what your Java track actually calls JUnit + Mockito —
I've built this folder using JUnit 5 + Mockito, which is what Cognizant's Deepskilling
handbook for Java FSE actually uses.)

## Folder structure
```
Cognizant-Week1/
├── 01-DesignPatterns/     Singleton, Factory, Observer, Strategy, Decorator
├── 02-DSA/                Arrays, LinkedList, Sorting, Searching, Recursion
├── 03-AdvancedSQL/        Joins, subqueries, window functions, CTEs, indexing
└── 04-JUnit-Mockito/      Unit testing a Service class with JUnit 5 + Mockito
```

Every folder has `exercises.md` describing the tasks. Java files have `// TODO` markers —
fill those in, don't delete them, keep filenames as-is.

## Compiling & running (no IDE needed)

Plain files (01, 02):
```bash
cd 01-DesignPatterns
javac *.java
java Main
```

For 04-JUnit-Mockito, you need Maven (has a `pom.xml` with JUnit 5 + Mockito already wired):
```bash
cd 04-JUnit-Mockito
mvn test
```

## Push to Git

```bash
cd Cognizant-Week1
git init
git add .
git commit -m "Week 1: Design Patterns, DSA, Advanced SQL, JUnit & Mockito"
git branch -M main
git remote add origin <your-empty-repo-url>
git push -u origin main
```

Commit per topic as you finish instead of one giant dump — cleaner history:
```bash
git add 01-DesignPatterns && git commit -m "Week1: Design patterns"
git add 02-DSA && git commit -m "Week1: DSA"
git add 03-AdvancedSQL && git commit -m "Week1: Advanced SQL"
git add 04-JUnit-Mockito && git commit -m "Week1: JUnit & Mockito"
git push
```

## Suggested order
1. Design Patterns (2–3 hrs)
2. DSA (3–4 hrs) — attempt before looking anything up
3. Advanced SQL (2 hrs) — run against any MySQL sandbox (db-fiddle.com works with no install)
4. JUnit & Mockito (2 hrs) — needs 1 & 2 mentally warmed up since it tests a small service
