// task_02.h
//
// A class named 'Foo' is declared below, and the implementation is
// given in 'task_02.cc'.
// 
// The task is to improve the implementation as you see fit, with
// emphasis on robustness in terms of implementation.
// 
// You are not allowed to change the public interface of Foo,
// (read 'public methods of Foo'), but feel free to make other
// changes and/or additions.

#pragma once

#include <string>

namespace rebtel_task_02 {

  class Mutex;
  
  class Foo {

 public:
    Foo();
    ~Foo();

    bool connect(const std::string& address);
    void disconnect();
    bool isConnected() const;

 private:
    Mutex* _mutex;
    std::string _address;
    bool _is_connected;

  };

  // Mutex, Cross-platform mutex wrapper
  // 
  // IMPORTANT: You do not need to implement this.
  // The purpose of the declaration below is to provide the
  // interface which is used in Foo's implementation.
  class Mutex {
 public:
    static Mutex* Create(){};
    virtual ~Mutex() = 0;
    virtual void Lock() = 0;
    virtual void Unlock() = 0;
  };

  // For the sake of simplicity, the Locker class is implemented directly in the
  // header file
  class Locker {
  public:
      explicit Locker(Mutex* mutex) : _mutex(mutex) {
          _mutex->Lock();
      }

      ~Locker() {
          _mutex->Unlock();
      }

  private:
      Mutex* _mutex;
      //make the instance of resource managing class uncopyable
      Locker(const Locker&);
      Locker& operator=(const Locker&);
  };
}
