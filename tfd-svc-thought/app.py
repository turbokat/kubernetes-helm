from flask import Flask,jsonify
import random 

app = Flask(__name__)

class Thought(object):
    """__init__() functions as the class constructor"""
    def __init__(self, author=None, thought=None):
        self.author = author
        self.thought = thought

    def serialize(self):  
        return {           
            'author': self.author, 
            'thought': self.thought
        }

thoughts = []
thoughts.append(Thought("Billy Connolly",
      "Before you judge a man, walk a mile in his shoes. After that who cares?... He's a mile away and you've got his shoes!"))
thoughts.append(Thought("A. A. Milne", "People say nothing is impossible, but I do nothing every day."))
thoughts.append(Thought("Abraham Lincoln",
          "Better to remain silent and be thought a fool than to speak out and remove all doubt."))
thoughts.append(Thought("Abraham Lincoln", "If I were two-faced, would I be wearing this one?"))
thoughts.append(Thought("Al McGuire", "The only mystery in life is why the kamikaze pilots wore helmets."))
thoughts.append(Thought("Alan Dundes",
          "Light travels faster than sound. This is why some people appear bright until you hear them speak."))
thoughts.append(Thought("Albert Camus", "Nobody realizes that some people expend tremendous energy merely to be normal."))
thoughts.append(Thought("Albert Einstein", "The difference between stupidity and genius is that genius has its limits."))
thoughts.append(Thought("Ann Landers",
          "At every party there are two kinds of people - those who want to go home and those who don't. The trouble is, they are usually married to each other."))
thoughts.append(Thought("Arthur C. Clarke", "I don't believe in astrology; I'm a Sagittarius and we're skeptical."))
thoughts.append(Thought("Ashleigh Brilliant", "My opinions may have changed, but not the fact that I'm right."))
thoughts.append(Thought("Ashleigh Brilliant",
          "To be sure of hitting the target, shoot first, and call whatever you hit the target."))
thoughts.append(Thought("Bernard Baruch",
          "Be who you are and say what you feel, because those who mind don't matter and those who matter don't mind."))

defaultThought = Thought("Commander Feral, Swat Kats", "Back off, Swat Kats! The Enforcers are here! This is Feral, bring me chopper backup!")

@app.route('/default-thought')
def default_thought():
    return jsonify(defaultThought.serialize())

@app.route('/thought-for-the-day')
def thought_for_the_day():
    return jsonify(thoughts[random.randint(0, 12)].serialize())

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)