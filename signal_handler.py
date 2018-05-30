import signal, os
import json

def handler(signum, frame):
    os.system("mvn test")

with open("/home/roman/eclipse-workspace/submit_task/Tasks/Task1.json") as handle:
        dictdump = json.loads(handle.read())
dictdump["pid"] = os.getpid()

with open("/home/roman/eclipse-workspace/submit_task/Tasks/Task1.json", 'w') as handle:
        json.dump(dictdump, handle)

signal.signal(signal.SIGUSR1, handler)
while True:
	signal.pause()
