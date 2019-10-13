import firebase_admin
import google.cloud
from firebase_admin import credentials,firestore

cred = credentials.Certificate("./serviceAccountKey.json")
app = firebase_admin.initialize_app(cred)

GlassBox = firestore.client()
doc_ref = GlassBox.collection(u"feedback")

from monkeylearn import MonkeyLearn

ml = MonkeyLearn('677d6facaab96b42a60484686053566e931cf4d5')
data = ["This is a great tool!"]
model_id = 'cl_pi3C7JiL'

sentiments = {}

try:
    docs = doc_ref.stream()
    for doc in docs:
        dict1 = doc.to_dict()
        result = ml.classifiers.classify(model_id, [dict1['feedback']])
        sentiments[doc.id]=result.body[0]['classifications'][0]['tag_name']
        
except google.cloud.exceptions.NotFound:
    print(u'Missing Data')


for id in sentiments:
    doc_ref.document(id).update({'sentiment':sentiments[id]})