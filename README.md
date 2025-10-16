# junit-pipeline-demo

A minimal Java (Maven) project with JUnit tests and a Jenkins Pipeline that runs the tests automatically on each push.

## How to use

1. **Create a new GitHub repo** (public or private).  
2. **Push this project** to that repo:
   ```bash
   git init
   git remote add origin <your-repo-url>
   git add .
   git commit -m "Initial commit: JUnit + Jenkins pipeline demo"
   git branch -M main
   git push -u origin main
   ```
3. **Jenkins setup** (once):
   - Install plugins: **Git**, **GitHub**, **Pipeline**, **JUnit**.
   - *Manage Jenkins → Tools*: add JDK (Name: `jdk17`) and Maven (Name: `M3`).
   - *Manage Jenkins → Credentials*: add your GitHub credentials or token if needed.
   - **Create a Pipeline job**:
     - *Pipeline from SCM* → SCM: **Git** → Repository URL: `<your-repo-url>` → Branch: `*/main`.
     - *Script Path*: `Jenkinsfile` (default).
     - In *Build Triggers*, check **GitHub hook trigger for GITScm polling**.
4. **GitHub webhook**:
   - In your repo: *Settings → Webhooks → Add webhook*.
   - Payload URL: `http(s)://<your-jenkins>/github-webhook/`  
     (If Jenkins is local, expose via **ngrok**: `ngrok http 8080` and use the HTTPS URL.)
   - Content type: `application/json`.
   - Events: **Just the push event**.
5. **Test it**: make a small change, `git push`. GitHub sends a webhook → Jenkins job runs → JUnit results appear in the build.

## Local test
```bash
mvn test
```
