from sqlalchemy import Column, Integer, BigInteger, String, Boolean, Float, DateTime
from datetime import datetime
from app.database import Base

class User(Base):
    __tablename__ = "users"

    id = Column(BigInteger, primary_key=True, index=True, default=100001)
    username = Column(String(64), unique=True, index=True, default="Player")
    nickname = Column(String(64), default="Producer")
    diamond_paid = Column(Integer, default=500)
    diamond_free = Column(Integer, default=1000)
    rhythm_points = Column(Integer, default=50000)
    dalcom_coins = Column(Integer, default=2000)
    headphones = Column(Integer, default=20)
    active_bg_code = Column(Integer, default=1001)
    profile_code = Column(Integer, default=1001)
    created_at = Column(DateTime, default=datetime.utcnow)

class UserCard(Base):
    __tablename__ = "user_cards"

    id = Column(BigInteger, primary_key=True, autoincrement=True)
    user_id = Column(BigInteger, index=True)
    card_code = Column(Integer, index=True)
    grade = Column(Integer, default=5) # 5 = R Grade
    level = Column(Integer, default=99)
    is_lock = Column(Boolean, default=False)
    is_equipped = Column(Boolean, default=False)

class UserSongRecord(Base):
    __tablename__ = "user_song_records"

    id = Column(BigInteger, primary_key=True, autoincrement=True)
    user_id = Column(BigInteger, index=True)
    music_code = Column(Integer, index=True)
    difficulty = Column(Integer) # 1: Easy, 2: Normal, 3: Hard
    high_score = Column(BigInteger, default=0)
    all_super_perfect = Column(Boolean, default=False)
    full_combo = Column(Boolean, default=False)
    clear_count = Column(Integer, default=0)
    updated_at = Column(DateTime, default=datetime.utcnow)
