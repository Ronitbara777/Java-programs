#include<stdio.h>
#include<stdlib.h>
struct node {
    int data;
    struct node* left;
    struct node* right;
};
struct node* cnode(int data){
    struct node* temp=(struct node* )malloc(sizeof(struct node));
    temp->data=data;
    temp->left=temp->right=NULL;
    return temp;
}
void intraverse(struct node* head){
    struct node* root=head;
    if(root==NULL){
        return ;
    }
    intraverse(root->left);
    printf("%d\t",root->data);
    intraverse(root->right);
}
void pretraverse(struct node* head){
    struct node* root=head;
    printf("%d\t",root->data);
    if(root->left==NULL&&root->right==NULL){
        return ;
    }
    pretraverse(root->left);
    pretraverse(root->right);
}
void postraverse(struct node* head){
    struct node* root=head;
    if(root->left==NULL&&root->right==NULL){
        printf("%d\t",root->data);
        return;
    }
    postraverse(root->left);
    postraverse(root->right);
    printf("%d\t",root->data);
}
void BFS(struct node* head){
    if(head==NULL) return ;
    struct node* queue[100];
    int front =0,rear=0;
    queue[rear++]=head;
    while(front<rear){
        struct node* node=queue[front++];
        printf("%d\t",node->data);
        if(node->left)
            queue[rear++]=node->left;
        if(node->right)
            queue[rear++]=node->right;
    }
}
struct node* insert(struct node* head, int data){
    if(head==NULL) return cnode(data);
    struct node* q[100];
    int front=0,rear=0;
    q[rear++]=head;
    while(front<rear){
        struct node* node=q[front++];
        if(node->left==NULL){
            node->left=cnode(data);
            break;
        }else{
            q[rear++]=node->left;
        }
        if(node->right==NULL){
            node->right=cnode(data);
            break;
        }else{
            q[rear++]=node->right;
        }
    }
    return head;
}
struct node* travR(struct node* head){
    struct node* curr=head;
    struct node* q[100];
    int front =0, rear=0;
    q[rear++]=curr;
    while(front<rear){
        struct node* temp=q[front++];
        if(temp->left) q[rear++]=temp->left;
        if(temp->right) q[rear++]=temp->right;
    }
    printf("%d",q[front]->data);
    return q[front];
    
}
struct node* delete(struct node* head,int data){
    if(head==NULL) return NULL;
    struct node* target=NULL;
    struct node* parent;
    struct node* q[100];
    int front=0,rear=0;
    q[rear++]=head;
    while(front<rear){
        struct node* temp=q[front++];
        if(temp->data==data){ 
            target=temp;
            break;
        }
        if(temp->left){
            q[rear++]=temp->left;
        }
        if(temp->right){
            q[rear++]=temp->right;
        }
    }
    if(target==NULL) return head;
    //Creating a node "swap" which will contain the rightmost node which is to replace the node which is to be deleted.
    struct node* swap;
    swap=travR(target->right);
    target->data=swap->data;
    free(swap);
    return head;
}
void main(){
    struct node* first=cnode(2);
    struct node* second=cnode(3);
    struct node* third=cnode(5);
    struct node* fourth=cnode(1);
    struct node* fifth=cnode(7);
    struct node* sixth=cnode(4);
    struct node* seventh=cnode(8);
    first->left=second;
    first->right=third;
    second->left=fourth;
    second->right=fifth;
    third->left=sixth;
    third->right=seventh;
    intraverse(first);
    printf("\n");
    pretraverse(first);
    printf("\n");
    postraverse(first);
    printf("\n");
    BFS(first);
    printf("\n");
    struct node* head=insert(first,9);
    BFS(head);
    printf("\n");
    delete(head,5);
    BFS(head);
}