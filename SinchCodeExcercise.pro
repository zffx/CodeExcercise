TEMPLATE = app
CONFIG += console
CONFIG -= app_bundle
CONFIG -= qt

SOURCES += main.cpp \
    task_01.cc \
    task_02.cc


include(deployment.pri)
qtcAddDeployment()

HEADERS += \
    task_01.h \
    task_02.h

