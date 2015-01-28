// task_02.cc 

#include "task_02.h"

// You will notice that the this is somewhat of a nonsense-
// implementation from a functional perspective, i.e. the connect(1)
// and disconnect() doesn't do much, but that is for the sake of the
// tasks simplicity.

namespace rebtel_task_02 {

Foo::Foo() : _mutex(Mutex::Create()) {
  
}

Foo::~Foo() {
  delete _mutex;
}

bool Foo::connect(const std::string& address) {
  _mutex->Lock();

  if(address.length() == 0){
    _mutex->Unlock();
    return false;
  }
  
  _address = std::string(address);
  _is_connected = true;
  
  _mutex->Unlock();

  return true;
}

void Foo::disconnect() {
  _mutex->Lock();

  if(!_is_connected){
    _mutex->Unlock();
    return;
  }

  _address = "";
  _is_connected = false;

  _mutex->Unlock();
  
}

bool Foo::isConnected() const {
  bool connected = false;
  _mutex->Lock();
  connected = _is_connected;
  _mutex->Unlock();
  return connected;
}

}
