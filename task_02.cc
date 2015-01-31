// task_02.cc 

#include "task_02.h"

// You will notice that the this is somewhat of a nonsense-
// implementation from a functional perspective, i.e. the connect(1)
// and disconnect() doesn't do much, but that is for the sake of the
// tasks simplicity.

namespace rebtel_task_02 {

//The initialization list is incomplete, fixed it below
Foo::Foo() :
    _mutex(Mutex::Create()),
    _address(std::string()),
    _is_connected(false){
  
}

Foo::~Foo() {
  delete _mutex;
}

bool Foo::connect(const std::string& address) {
  // Use RAII to control the lock here
  // _mutex->Lock();

  Locker locker(_mutex);

  //should we check _is_connected here before setting the values?

  if(address.length() == 0){
    // The next line is not needed anymore as Unlock() will be
    // called by ~Locker() anyway when execution leaves the function
    // _mutex->Unlock();
    return false;
  }
  
  _address = std::string(address);
  _is_connected = true;

  // commented out for the same reason as above, this is a much easier way of
  // maintaining code too
  //_mutex->Unlock();

  return true;
}

void Foo::disconnect() {
  //_mutex->Lock();
  Locker locker(_mutex);

  if(!_is_connected){
    //_mutex->Unlock();
    return;
  }

  _address = "";
  _is_connected = false;

  //_mutex->Unlock();
  
}

bool Foo::isConnected() const {
  bool connected = false;
  Locker locker(_mutex);
  //_mutex->Lock();
  connected = _is_connected;
  //_mutex->Unlock();
  return connected;
}

}
