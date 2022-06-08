# AI 기반 스마트물류 무인관리 시스템 개발

# 📜 프로젝트 소개

---

- 항만은 많은 관리자가 상주하지만 상황에 따라 관리가 어렵다.
- 따라서 항만 내 여러 곳에 AI기반 카메라를 설치한 후, 실시간으로 현장을 관찰하며 무단 침입자 발생 등과 같은 상황 발생시
즉시 관리자에게 상황을 알리는 시스템을 만든다.
- 최종적으로 본 프로젝트는 딥러닝을 기반으로 항만 내에서 발생 가능한 다양한 사건들의 패턴을 학습해 모델을 구축한 후, 
항만 내에 ipcam 등을 설치해 **위험 상황을 식별하면 관리자에게 알림을 주는 서비스**를 만들어 관리자가 자신이 없는 장소
에서 발생한 위험 상황에 빠른 대처가 가능하도록 돕는 것을 목표로 한다.

## 프로젝트 기간

---

**2022.06月 ~ 2022.11月**

## 개발 환경 및 사용할 라이브러리, 프레임워크, 기술

| 라이브러리/프레임워크/기술 | 목적 |
| --- | --- |
| OpenCV | 실시간 영상 프로세싱 |
| React | 관리자 웹 화면 개발 |
| Spring | 서버 구축 |
| WebRTC | 실시간 cctv 영상 전송 |

## 역할 분담

- 의양 ➡️ 백엔드 중심 개발,
- 창호 ➡️ 딥러닝 모델 중심 개발,
- 상현 ➡️ 관리자 화면 개발, 백엔드 개발

## ip camera → 웹페이지 영상 전송 관련